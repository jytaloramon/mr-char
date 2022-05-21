package br.com.mrchat.socket;

import java.io.DataOutputStream;
import java.io.IOException;

import br.com.mrchat.chat.ChatCommunicationSendBase;

public class ChatCommunicationSendSocket
        extends ChatCommunicationSendBase implements Runnable {

    public ChatCommunicationSendSocket(DataOutputStream dataOutputStream) {
        super(dataOutputStream);
    }

    @Override
    public void run() {
        while (true) {
            try {
                runSend("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
