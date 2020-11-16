package com.ifmo.jjd.lesson20.socketio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private Connection connection;


    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(8090)){
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                System.out.println(connection.readMessage());
                connection.sendMessage(SimpleMessage.getMessage("от", "получего"));
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
