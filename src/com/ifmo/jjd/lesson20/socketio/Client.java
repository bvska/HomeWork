package com.ifmo.jjd.lesson20.socketio;




import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;

    Properties cChat = new Properties();


    public void setIp(String ip) {
        try {
            cChat.load(new FileInputStream("source/configchat.properties"));
            ip = cChat.getProperty("host");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.ip = ip;
    }

    public void setPort(int port) {
        try {
            cChat.load(new FileInputStream("source/configchat.properties"));
            port = Integer.parseInt(cChat.getProperty("port"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public Client() {
        setIp(ip);
        setPort(port);
        scanner = new Scanner(System.in);
    }

    public void start() throws Exception {
        System.out.println("введите имя");
        String name = scanner.nextLine();

        String message;
        while (true){
            System.out.println("Введите сообщение");
            message = scanner.nextLine();
//            if (message.equals("help"))
//                System.out.println(message);
            sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }

    }




    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(new Socket(ip, port))){
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            System.out.println("от сервера " + fromServer);
        }
    }
    public static void main(String[] args) {
        // ip 127.0.0.1 : 8090
        try {
            new Client().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // если необходимо запустить параллельно несколько клиентов
        // Client -> edit configurations -> allow parallel run
    }
}
