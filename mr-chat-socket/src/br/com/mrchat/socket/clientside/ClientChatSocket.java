package br.com.mrchat.socket.clientside;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.mrchat.chat.clientside.IChatClient;

public class ClientChatSocket implements IChatClient {

    private final Socket socket;

    public ClientChatSocket(String host, int port) throws UnknownHostException, IOException {

        this.socket = new Socket(host, port);

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        System.out.println("------ Chat iniciado ------");

        Thread threadReceive = new Thread(new ClientChatSocketReceiveThread(inputStream)),
                threadSend = new Thread(new ClientChatSocketSendThread(outputStream));

        threadSend.start();
        threadReceive.start();
    }

}
