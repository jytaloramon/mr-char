import proto.chat_pb2 as chat
import proto.chat_pb2_grpc as rpc

class ChatServer(rpc.ChatServerServicer):  # inheriting here from the protobuf rpc file which is generated

    def __init__(self):
        self.__chats = []

    def ChatStream(self, request_iterator, context):
        lastindex = 0

        while True:
            while len(self.__chats) > lastindex:
                n = self.__chats[lastindex]
                lastindex += 1
                yield n

    def SendNote(self, request: chat.Note, context):
       
        # Add it to the chat history
        self.__chats.append(request)
        return chat.Empty()  # something needs to be returned required by protobuf language, we just return empty msg

