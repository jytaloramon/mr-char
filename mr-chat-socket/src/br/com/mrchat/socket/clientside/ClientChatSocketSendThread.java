package br.com.mrchat.socket.clientside;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.mrchat.chat.common.ChatObjectStreamSend;
import br.com.mrchat.chat.common.Message;

public class ClientChatSocketSendThread extends ChatObjectStreamSend implements Runnable {

    public ClientChatSocketSendThread(ObjectOutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();

        try {
            this.runSend(new Message(name + " entrou!"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        System.out.println("Seja bem vindo!\n");

        while (true) {

            String text = sc.nextLine();
            Message message = new Message(name + " - " + text
                    + " [" + dateTimeFormatter.format(LocalTime.now()) + "]");

            try {
                this.runSend(message);
            } catch (IOException e) {
                System.out.println("Saindo...");
                break;
            }
        }

    }

}
