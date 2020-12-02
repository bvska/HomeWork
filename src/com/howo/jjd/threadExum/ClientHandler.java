package com.howo.jjd.threadExum;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    SimpleMessage message;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.input = new ObjectInputStream(socket.getInputStream());
            this.output = new ObjectOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        message = (SimpleMessage) input.readObject();
                        if (message.getText().equals("/exit")) {
                            System.out.println("Клиент отключен");
                            break;
                        }
                        System.out.println("Сообщение от клиента " + message);
                        server.broadcastMess(SimpleMessage.getMessage(message.getSender(), message.getText(), message.getDateTime()), socket.getPort());
                    }

                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public void sendMess (SimpleMessage message){
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
