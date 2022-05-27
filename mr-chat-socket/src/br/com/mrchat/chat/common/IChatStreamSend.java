package br.com.mrchat.chat.common;

import java.io.IOException;

public interface IChatStreamSend {

    public void runSend(Message message) throws IOException;

}
