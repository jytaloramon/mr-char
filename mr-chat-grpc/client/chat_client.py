from datetime import datetime
import threading
import grpc

import proto.chat_pb2 as chat
import proto.chat_pb2_grpc as rpc


class ChatClient:

    def __init__(self, u: str, connection: rpc.ChatServerStub):
        self.__username = u
        self.__conn = connection

        threading.Thread(target=self.__messages_listen, daemon=True).start()
        self.send_message('entrou!')
        self.__read_msg()

    def __messages_listen(self):

        for note in self.__conn.ChatStream(chat.Empty()):
            if self.__username != note.name:
                print(f"> {note.name} - {note.message}")

    def send_message(self, msg):

        if msg != '':
            n = chat.Note()
            n.name = self.__username
            time_send = datetime.now()
            n.message = f'{msg} [{time_send.hour}:{time_send.minute}]'

            self.__conn.SendNote(n)

    def __read_msg(self):

        while True:
            msg = input('')
            self.send_message(msg)
