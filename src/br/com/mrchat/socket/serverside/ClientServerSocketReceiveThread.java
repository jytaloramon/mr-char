package br.com.mrchat.socket.serverside;

import java.io.IOException;

import br.com.mrchat.chat.IChatCommunicationReceive;
import br.com.mrchat.chat.Message;
import br.com.mrchat.chat.serverside.IChatServer;
import br.com.mrchat.chat.serverside.IChatServerEvent;

public class ClientServerSocketReceiveThread implements Runnable {

    private final int port;
    private final IChatServer owner;
    private final IChatCommunicationReceive communicationReceive;

    public ClientServerSocketReceiveThread(int port, IChatCommunicationReceive communicationReceive,
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
