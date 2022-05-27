package br.com.mrchat.chat.common;

import java.io.IOException;

public interface IChatStreamReceive {

    public Message runReceive() throws IOException, ClassNotFoundException;

}
