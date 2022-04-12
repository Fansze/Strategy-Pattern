package com.example.demo21;
import java.io.*;
public interface EncryptStrategy {
    public abstract void encryptFile(File file,File file2);
    public abstract void decryptFile(File file,File file2);
}
