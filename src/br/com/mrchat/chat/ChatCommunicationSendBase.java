package br.com.mrchat.chat;

import java.io.DataOutputStream;
import java.io.IOException;

public class ChatCommunicationSendBase implements IChatCommunicationSend {

    private DataOutputStream dataOutputStream;

    public ChatCommunicationSendBase(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void runSend(String content) throws IOException {
        this.dataOutputStream.writeBytes(content);
    }
}
