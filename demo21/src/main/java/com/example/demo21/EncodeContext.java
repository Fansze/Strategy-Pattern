package com.example.demo21;
import java.io.*;
public class EncodeContext {
    EncryptStrategy strategy;

    public void setStrategy(EncryptStrategy strategy) {
        this.strategy = strategy;
    }
    public void encryptFile(File file,File file2){
        strategy.encryptFile(file,file2);
    }
    public void decryptFile(File file,File file2){
        strategy.decryptFile(file,file2);
    }
}
