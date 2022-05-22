package br.com.mrchat.chat;

import java.io.IOException;

public interface IChatCommunicationSend {

    public void runSend(Message message) throws IOException;

}
