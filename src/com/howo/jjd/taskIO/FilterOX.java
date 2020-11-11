package com.howo.jjd.taskIO;


import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FilterOX extends FilterOutputStream {
    public FilterOX(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte key = 100;
        for (int i = 0; i < b.length; i++) {
        b[i] = (byte) (b[i]^key);

    }
        out.write(b);
}
    }