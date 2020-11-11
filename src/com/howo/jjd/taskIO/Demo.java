package com.howo.jjd.taskIO;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        File taskFile = new File("source/taskIO.txt");

        try {
            FilterOX filterOX = new FilterOX(new FileOutputStream(taskFile));
            filterOX.write("просто текс 12345".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        FilterIX filterIX = new FilterIX(new FileInputStream(taskFile));

        filterIX.read(new byte[(int) taskFile.length()]);




    }
}
