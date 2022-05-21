package br.com.mrchat.chat;

import java.io.DataInputStream;
import java.io.IOException;

public class ChatCommunicationReceiveBase implements IChatCommunicationReceive {

    private DataInputStream dataInputStream;

    public ChatCommunicationReceiveBase(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    @Override
    public String runReceive() throws IOException {
        return this.dataInputStream.readAllBytes().toString();
    }

}
