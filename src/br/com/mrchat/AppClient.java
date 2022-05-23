package br.com.mrchat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.com.mrchat.chat.clientside.IChatClient;
import br.com.mrchat.chat.common.Message;
import br.com.mrchat.socket.clientside.ClientChatSocket;

public class AppClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        IChatClient appClientSocket = new ClientChatSocket("localhost", 5432);

    }

}
