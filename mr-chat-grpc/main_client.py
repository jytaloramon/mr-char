import grpc
import proto.chat_pb2_grpc as rpc
from client.chat_client import ChatClient


def main():
    ADDR = 'localhost'
    PORT = '9760'

    channel = grpc.insecure_channel(ADDR + ':' + PORT)
    conn = rpc.ChatServerStub(channel)

    print('------ Chat gRPC Iniciando.. ------')
    name = input("Digite seu nome: ")

    c = ChatClient(name, conn)


if __name__ == '__main__':
    main()
