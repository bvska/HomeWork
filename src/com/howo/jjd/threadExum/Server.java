package com.howo.jjd.threadExum;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;


public class Server {
    private CopyOnWriteArrayList<ClientHandler> clientName;
    private CopyOnWriteArrayList<String> nameList;

    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(8090)) {
            clientName = new CopyOnWriteArrayList<>();
            nameList = new CopyOnWriteArrayList<>();
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключен");
                subscribe(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clientName.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clientName.remove(clientHandler);
    }

    public void broadcastMess(SimpleMessage message, int port) {
        for (ClientHandler c : clientName) {
            if (port == c.getSocket().getPort())
                continue;
            c.sendMess(message);
        }
    }

    public void delName(String name){
        nameList.remove(name);
    }

    public  boolean addName(String name) {
        for (String c : nameList) {
            if (name.equals(c))
                return true;
        }
        nameList.add(name);
        return false;
    }
}
