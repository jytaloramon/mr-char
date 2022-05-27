package br.com.mrchat.socket.serverside;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import br.com.mrchat.chat.common.ChatObjectStreamReceive;
import br.com.mrchat.chat.common.ChatObjectStreamSend;
import br.com.mrchat.chat.common.Message;

public class ServerChatSocketClient {

    private final Socket socket;
    private final ServerChatSocket owner;
    private final ObjectInputStream inputStream;
    private final ObjectOutputStream outputStream;

    private final Thread receiveThread;
    private final ChatObjectStreamSend send;

    // private final Thread

    public ServerChatSocketClient(Socket socket, ServerChatSocket owner) throws IOException, ClassNotFoundException {

        this.socket = socket;
        this.owner = owner;

        InputStream ipS = this.socket.getInputStream();
        OutputStream otS = this.socket.getOutputStream();
        this.outputStream = new ObjectOutputStream(otS);
        this.inputStream = new ObjectInputStream(ipS);

        this.receiveThread = new Thread(
                new ServerChatSocketClientReceiveThread(this.socket.getPort(),
                        new ChatObjectStreamReceive(this.inputStream), this.owner));

        this.send = new ChatObjectStreamSend(this.outputStream);
        this.receiveThread.start();

        System.out.println("+ Client " + socket.getPort() + " ENTROU");

    }

    public ChatObjectStreamSend getSend() {
        return send;
    }

}
