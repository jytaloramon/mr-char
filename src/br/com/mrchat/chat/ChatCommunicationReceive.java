package br.com.mrchat.chat;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ChatCommunicationReceive implements IChatCommunicationReceive {

    private ObjectInputStream inputStream;

    public ChatCommunicationReceive(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public Message runReceive() throws IOException, ClassNotFoundException {
        return (Message) this.inputStream.readObject();
    }

}
