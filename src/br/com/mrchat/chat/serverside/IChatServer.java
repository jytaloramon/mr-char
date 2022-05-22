package br.com.mrchat.chat.serverside;

import java.io.IOException;

public interface IChatServer extends IChatServerEvent {

    public void up() throws IOException;

    public void removeClient(int id);

}
