package br.com.mrchat.chat;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ChatCommunicationSend implements IChatCommunicationSend {

    private ObjectOutputStream outputStream;

    public ChatCommunicationSend(ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void runSend(Message message) throws IOException {
        this.outputStream.writeObject(message);
    }
}
