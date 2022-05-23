package br.com.mrchat.socket.clientside;

import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.mrchat.chat.common.ChatObjectStreamReceive;

public class ClientChatSocketReceiveThread extends ChatObjectStreamReceive implements Runnable {

    public ClientChatSocketReceiveThread(ObjectInputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("> " + this.runReceive());
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("Saindo...");
                break;
            }
        }
    }

}
