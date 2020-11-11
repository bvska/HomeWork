package com.howo.jjd.taskIO;

import java.io.*;

public class FilterIX extends FilterInputStream {
    public FilterIX(InputStream in) throws FileNotFoundException {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        byte key = 100;
        String res = "";
        int data;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        while ((data = in.read(b)) != -1) {
            for (int i = 0; i < b.length; i++) {
                b[i] = (byte) (b[i] ^ key);
            }
            byteArray.write(b, 0, data);
        }

        res = new String(byteArray.toByteArray());

        System.out.println(res);

        return in.read(b);
    }


}
