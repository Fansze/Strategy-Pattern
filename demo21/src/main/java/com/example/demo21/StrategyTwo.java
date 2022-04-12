package com.example.demo21;
import java.io.*;
public class StrategyTwo implements EncryptStrategy{
    String password;
    StrategyTwo() {
        this.password = "hello world";
    }
    StrategyTwo(String password) {
        if (password.length() == 0) {
            this.password = "hello world";
        }
        this.password = password;
    }
    public void encryptFile(File file,File file2) {
        try {
            byte[] a = password.getBytes();
            FileInputStream in = new FileInputStream(file);
            long length = file.length();
            byte[] c = new byte[(int) length];
            int m = in.read(c);
            for (int k = 0; k < m; k++) {
                int n = c[k]^a[k % a.length];
                c[k] = (byte) n;
            }
            in.close();
            OutputStream out = new FileOutputStream(file2);
            out.write(c, 0, m);
            out.close();
        } catch (IOException e) {
            System.out.println("加密出错!");
        }
    }
    public void decryptFile(File file,File file2) {
        try {
            byte[] a = password.getBytes();
            FileInputStream in = new FileInputStream(file);
            long length = file.length();
            byte[] c = new byte[(int) length];
            int m = in.read(c);
            for (int k = 0; k < m; k++) {
                int n = c[k]^a[k % a.length];
                c[k] = (byte) n;
            }
            in.close();
            OutputStream out = new FileOutputStream(file2);
            out.write(c, 0, m);
            out.close();
        } catch (IOException e) {
           System.out.println("解密出错!");
        }
    }
}

