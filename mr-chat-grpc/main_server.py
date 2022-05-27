import grpc
from concurrent import futures
from proto import chat_pb2_grpc as rpc
from server.chat_server import ChatServer


def main():

    HOST = '[::]'
    PORT = '9760'

    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    rpc.add_ChatServerServicer_to_server(ChatServer(), server)

    server.add_insecure_port(HOST + ':' + PORT)
    server.start()
    print(f'------ Server gRPC Up ({HOST}{PORT})------')
    server.wait_for_termination()


if __name__ == '__main__':
    main()
