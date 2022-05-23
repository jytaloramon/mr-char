package br.com.mrchat;

import java.io.IOException;

import br.com.mrchat.chat.serverside.IChatServer;
import br.com.mrchat.socket.serverside.ServerChatSocket;

public class AppServer {
    
    public static void main(String[] args) throws IOException {
        
        IChatServer appServerSocket = new ServerChatSocket(5432);

        appServerSocket.up();

    }

}
