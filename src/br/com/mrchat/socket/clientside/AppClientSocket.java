package br.com.mrchat.socket.clientside;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.mrchat.chat.clientside.IChatClient;

public class AppClientSocket implements IChatClient {

    private final Socket socket;

    public AppClientSocket(String host, int port) throws UnknownHostException, IOException {

        this.socket = new Socket(host, port);

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        System.out.println("Chat iniciado");

        Thread threadReceive = new Thread(new ClientSocketReceiveThread(inputStream)),
                threadSend = new Thread(new ClientSocketSendThread(outputStream));

        threadSend.start();
        threadReceive.start();
    }

}
