package br.com.mrchat.socket.clientside;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import br.com.mrchat.chat.ChatCommunicationSend;
import br.com.mrchat.chat.Message;

public class ClientSocketSendThread extends ChatCommunicationSend implements Runnable {

    public ClientSocketSendThread(ObjectOutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            String text = sc.nextLine();
            Message message = new Message(text);
            
            try {
                this.runSend(message);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
