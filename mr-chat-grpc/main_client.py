import grpc

import proto.chat_pb2_grpc as rpc
from client.chat_client import ChatClient

if __name__ == '__main__':

    ADDR = 'localhost'
    PORT = 11912

    channel = grpc.insecure_channel(ADDR + ':' + str(PORT))
    conn = rpc.ChatServerStub(channel)

    username = input("Digite seu username: ")
    c = ChatClient(username, conn)
