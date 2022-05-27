package br.com.mrchat;

import java.io.IOException;
import java.net.InetAddress;

import br.com.mrchat.chat.serverside.IChatServer;
import br.com.mrchat.socket.serverside.ServerChatSocket;

public class AppServer {

    public static void main(String[] args) throws IOException {

        final String HOST = "localhost";
        final int PORT = 9753, BACKLOG = 15;

        InetAddress socketAddress = InetAddress.getByName(HOST);

        IChatServer appServerSocket = new ServerChatSocket(socketAddress, PORT, BACKLOG);

        appServerSocket.up();

    }

}
