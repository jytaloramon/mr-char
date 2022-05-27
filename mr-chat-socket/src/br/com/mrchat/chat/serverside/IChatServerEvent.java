package br.com.mrchat.chat.serverside;

import java.io.IOException;

import br.com.mrchat.chat.common.Message;

public interface IChatServerEvent {

    public void notifyNewMessage(int idCli, Message message) throws IOException;

}
