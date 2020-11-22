package com.ifmo.jjd.lesson20.socketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class SimpleServer {
    private Connection connection;
    Set<String> clientName = new HashSet<>();

    // тут надо сделать Map<String, Integer> (имя клиента и порт сокета)
    // 1. это то что можно оценивать кто из клиентов реально подсоединне.
    // + отправка сообщений в дальнейшем



    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(8090)){
            System.out.println("Server started");
            while (true) {

                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                SimpleMessage message = connection.readMessage();
                System.out.println(message);
                if (message.getText().equals("connect"))
                    clientName.add(message.getSender());
                // если пользователь отключился его надо удалять
                if (message.getText().equals("exit"))
                    clientName.remove(message.getSender());
                if (message.getText().equals("ping")) {
                    try {
                        // если это убрать то на одно машине задержек нет(время одинакого)
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    connection.sendMessage(SimpleMessage.getMessage("от", "ping"));}
                if (message.getText().equals("help"))
                    connection.sendMessage(SimpleMessage.getMessage
                            ("от", "server: доступные команды: ping, count, help, exit "));
                if (message.getText().equals("count"))
                    connection.sendMessage(SimpleMessage.getMessage
                            ("от", "server: количество соединений " + clientName.size()));
                // все остальные сообщения командыми не считаем

                connection.sendMessage(SimpleMessage.getMessage("от", "получено server"));

            }
        }
    }

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
} // ip 127.0.0.1 : 8090
