import threading
import grpc

import proto.chat_pb2 as chat
import proto.chat_pb2_grpc as rpc


class ChatClient:

    def __init__(self, u: str, connection: rpc.ChatServerStub):
        self.__username = u
        self.__conn = connection

        threading.Thread(target=self.__messages_listen, daemon=True).start()
        self.__read_msg()

    def __messages_listen(self):

        for note in self.__conn.ChatStream(chat.Empty()):
            if self.__username != note.name:
                print(f"> {note.name} - {note.message}")

    def send_message(self, msg):

        if msg != '':
            n = chat.Note()  # create protobug message (called Note)
            n.name = self.__username  # set the username
            n.message = msg  # set the actual message of the note
            self.__conn.SendNote(n)  # send the Note to the server

    def __read_msg(self):

        while True:
            msg = input('')
            self.send_message(msg)
