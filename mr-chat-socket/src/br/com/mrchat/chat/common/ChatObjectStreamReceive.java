package br.com.mrchat.chat.common;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ChatObjectStreamReceive implements IChatStreamReceive {

    private final ObjectInputStream inputStream;

    public ChatObjectStreamReceive(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    @Override
    public Message runReceive() throws IOException, ClassNotFoundException {

        return (Message) this.inputStream.readObject();
    }

}
