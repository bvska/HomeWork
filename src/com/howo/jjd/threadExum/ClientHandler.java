package com.howo.jjd.threadExum;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private SimpleMessage message;


    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.input = new ObjectInputStream(socket.getInputStream());
            this.output = new ObjectOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    message = (SimpleMessage) input.readObject();
                    if (server.addName(message.getSender().toLowerCase())){
                        this.sendMess(SimpleMessage.getMessage
                                ("Сервер: ", "Такое имя уже используется, измените и перезайдите", message.getDateTime()));
                        input.close();
                        socket.close();
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    while (true) {
                        message = (SimpleMessage) input.readObject();
                        if (message.getText().equals("/exit")) {
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
                        output.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                    server.delName(message.getSender());
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void sendMess(SimpleMessage message) {
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
