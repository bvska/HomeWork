package com.howo.jjd.threadExum;


public class MainClient {
    public static void main(String[] args) {
        try {
            new Client("127.0.0.1", 8090).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

