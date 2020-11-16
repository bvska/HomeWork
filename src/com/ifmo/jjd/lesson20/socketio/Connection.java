package com.ifmo.jjd.lesson20.socketio;


import com.ifmo.jjd.lesson20.socketio.SimpleMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//AutoCloseable + close() позволит создать объекты в try-with-sources блоке
public class Connection implements AutoCloseable{
    // Объект Socket позволит клиенту установить соединение
    // с сервером, а серверу принять клиента

    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;


    // client ======== server

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream());
        // ObjectOutputStream = преобразует \ this.socket.getOutputStream = передает

        input = new ObjectInputStream(this.socket.getInputStream());
    }



    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }



    @Override // будет вызван автоматически после завершения try блока
    // если объект Connection был создан в () try
    public  void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
