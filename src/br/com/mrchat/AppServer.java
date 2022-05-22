package br.com.mrchat;

import java.io.IOException;

import br.com.mrchat.socket.serverside.AppServerSocket;

public class AppServer {
    
    public static void main(String[] args) throws IOException {
        
        AppServerSocket appServerSocket = new AppServerSocket(5432);

        appServerSocket.up();

    }

}
