package br.com.mrchat.socket.serverside;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import br.com.mrchat.chat.ChatCommunicationReceive;
import br.com.mrchat.chat.ChatCommunicationSend;

public class ClientServerSocket {

    private final Socket socket;
    private final AppServerSocket owner;
    private final ObjectInputStream inputStream;
    private final ObjectOutputStream outputStream;

    private final Thread receiveThread;
    private final ChatCommunicationSend send;

    // private final Thread

    public ClientServerSocket(Socket socket, AppServerSocket owner) throws IOException {

        this.socket = socket;
        this.owner = owner;

        InputStream ipS = this.socket.getInputStream();
        OutputStream otS = this.socket.getOutputStream();

        this.outputStream = new ObjectOutputStream(otS);
        this.inputStream = new ObjectInputStream(ipS);

        this.receiveThread = new Thread(
                new ClientServerSocketReceiveThread(this.socket.getPort(),
                        new ChatCommunicationReceive(this.inputStream), this.owner));

        this.send = new ChatCommunicationSend(this.outputStream);
        this.receiveThread.start();
    }

    public ChatCommunicationSend getSend() {
        return send;
    }

}
