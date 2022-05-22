package br.com.mrchat.socket.clientside;

import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.mrchat.chat.ChatCommunicationReceive;

public class ClientSocketReceiveThread extends ChatCommunicationReceive implements Runnable {

    public ClientSocketReceiveThread(ObjectInputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("> " + this.runReceive());
            } catch (ClassNotFoundException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
