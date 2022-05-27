import proto.chat_pb2 as chat
import proto.chat_pb2_grpc as rpc


# inheriting here from the protobuf rpc file which is generated
class ChatServer(rpc.ChatServerServicer):

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

        self.__chats.append(request)
        print(f'Msgs: {request.name} - {request.message}')
        return chat.Empty()
