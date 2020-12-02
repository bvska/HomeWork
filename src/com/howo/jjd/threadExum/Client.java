package com.howo.jjd.threadExum;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private String ip;
    private int port;
    private Scanner scanner;
    private Socket socket;
    private String name;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);

    }


    public void start()  {
        try {
            socket = new Socket(ip, port);
            output = new ObjectOutputStream(this.socket.getOutputStream());
            input = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введите имя:");
        name = scanner.nextLine();
        ts1.start();
        ts.start();
    }

    Thread ts1 = new Thread(() -> {
        try {
            while (true) {
                System.out.println(this.readMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    });

    Thread ts = new Thread(() -> {
        try {
            while (true) {
                System.out.println("Введите сообщение");
                String message = scanner.nextLine();
                this.sendMessage(SimpleMessage.getMessage(name, message, LocalDateTime.now()));
                if (message.equals("/exit")) {
                    System.out.println("Клиент отключен");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    });


    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

}

