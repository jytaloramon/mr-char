package br.com.mrchat.socket.serverside;

import java.io.IOException;

import br.com.mrchat.chat.common.IChatStreamReceive;
import br.com.mrchat.chat.common.Message;
import br.com.mrchat.chat.serverside.IChatServer;

public class ServerChatSocketClientReceiveThread implements Runnable {

    private final int port;
    private final IChatServer owner;
    private final IChatStreamReceive communicationReceive;

    public ServerChatSocketClientReceiveThread(int port, IChatStreamReceive communicationReceive,
            IChatServer owner) {

        this.port = port;
        this.owner = owner;
        this.communicationReceive = communicationReceive;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = this.communicationReceive.runReceive();
                this.owner.notifyNewMessage(port, message);
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("+ Client " + this.port + " SAIU");
                this.owner.removeClient(this.port);
                break;
            }

        }
    }

}
