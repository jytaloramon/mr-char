package br.com.mrchat.chat;

import java.io.IOException;

public interface IChatCommunicationReceive {

    public Message runReceive() throws IOException, ClassNotFoundException;

}
