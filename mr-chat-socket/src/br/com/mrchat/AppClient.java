package br.com.mrchat;

import java.io.IOException;
import java.net.UnknownHostException;
import br.com.mrchat.chat.clientside.IChatClient;
import br.com.mrchat.socket.clientside.ClientChatSocket;

public class AppClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        final String HOST = "localhost";
        final int PORT = 9753;

        IChatClient appClientSocket = new ClientChatSocket(HOST, PORT);

    }

}
