package br.com.mrchat.socket;

import java.io.DataInputStream;
import java.io.IOException;

import br.com.mrchat.chat.ChatCommunicationReceiveBase;

public class ChatCommunicationReceiveSocket
        extends ChatCommunicationReceiveBase implements Runnable {

    public ChatCommunicationReceiveSocket(DataInputStream dataInputStream) {
        super(dataInputStream);
    }

    @Override
    public void run() {
        while (true) {
            try {
                runReceive();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
