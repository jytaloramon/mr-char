package br.com.mrchat.socket.serverside;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import br.com.mrchat.chat.common.Message;
import br.com.mrchat.chat.serverside.IChatServer;

public class ServerChatSocket implements IChatServer {

    private final ServerSocket serverSocket;
    private final HashMap<Integer, ServerChatSocketClient> clients;

    public ServerChatSocket(InetAddress addr, int port, int backlog) throws IOException {

        this.serverSocket = new ServerSocket(port, backlog, addr);

        this.clients = new HashMap<>();
    }

    public void up() {

        System.out.println("------ Server Up ("
                + this.serverSocket.getInetAddress().getHostAddress() +
                "[" + this.serverSocket.getLocalPort() + "]" + ") ------");

        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                ServerChatSocketClient clientServer = new ServerChatSocketClient(socket, this);

                clients.put(socket.getPort(), clientServer);
            } catch (Exception e) {
                System.out.println("@ Houve um erro ao conectar com o Cliente");
            }
        }

    }

    public void notifyNewMessage(int idCli, Message message) throws IOException {

        for (Integer key : this.clients.keySet()) {
            if (key != idCli) {
                ServerChatSocketClient chatSocketClient = this.clients.get(key);

                Message newMessage = message;
                chatSocketClient.getSend().runSend(newMessage);
            }
        }
    }

    public void removeClient(int id) {

        clients.remove(id);
    }

}
