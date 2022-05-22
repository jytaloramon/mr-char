package br.com.mrchat.socket.serverside;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import br.com.mrchat.chat.serverside.IChatServer;
import br.com.mrchat.chat.Message;

public class AppServerSocket implements IChatServer {

    private final ServerSocket serverSocket;
    private final HashMap<Integer, ClientServerSocket> clients;

    public AppServerSocket(int port) throws IOException {

        this.serverSocket = new ServerSocket(port);
        this.clients = new HashMap<>();
    }

    public void up() throws IOException {

        while (true) {

            Socket socket = this.serverSocket.accept();
            ClientServerSocket clientServer = new ClientServerSocket(socket, this);

            System.out.println("+ Client " + socket.getPort() + " ENTROU");

            clients.put(socket.getPort(), clientServer);
        }

    }

    public void notifyNewMessage(int idCli, Message message) throws IOException {

        for (Integer key : this.clients.keySet()) {
            if (key != idCli) {
                Message newMessage = new Message(idCli + " - " + message);
                this.clients.get(key).getSend().runSend(newMessage);
            }
        }
    }

    public void removeClient(int id){

        clients.remove(id);
    }

}
