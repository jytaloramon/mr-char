package br.com.mrchat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.com.mrchat.chat.Message;
import br.com.mrchat.socket.clientside.AppClientSocket;

public class AppClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        AppClientSocket appClientSocket = new AppClientSocket("localhost", 5432);

    }

}
