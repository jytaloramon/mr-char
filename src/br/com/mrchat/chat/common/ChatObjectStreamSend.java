package br.com.mrchat.chat.common;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ChatObjectStreamSend implements IChatStreamSend {

    private final ObjectOutputStream outputStream;

    public ChatObjectStreamSend(ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void runSend(Message message) throws IOException {
        this.outputStream.writeObject(message);
    }
}
