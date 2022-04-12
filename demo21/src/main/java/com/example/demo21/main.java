package com.example.demo21;
import java.io.*;
import java.util.Scanner;

public  class main {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要加密或解密的文件名:");
        String name = scanner.next();
        System.out.println("请输入:" + "\n1--加密方法一" + "\n2--加密方法二" + "\n3--解密文件");
        int i = scanner.nextInt();
        String h=null;
        if (i==3) {
            System.out.println("请输入解密后文件后缀:");
            h = scanner.next();
        }

        System.out.println(h);
        File decfile = new File("C:/Users/86157/Desktop/dec."+h);
        File encfile = new File("C:/Users/86157/Desktop/" + name);
        File fileOne = new File("C:/Users/86157/Desktop/"+name);
        String ss=decfile.getCanonicalPath();
        System.out.println(ss);

        String s = "";
        if (i == 1) {
            encfile = new File("C:/Users/86157/Desktop/enc.one");
            EncodeContext enc = new EncodeContext();
            enc.setStrategy(new StrategyOne("设计模式"));
            enc.encryptFile(fileOne, encfile);
            System.out.println(fileOne.getName() + "加密方法一加密后内容:");
            try {
                FileReader inOne = new FileReader(encfile);
                BufferedReader inTwo = new BufferedReader(inOne);
                while ((s = inTwo.readLine()) != null) {
                    System.out.println(s);
                }
                try {
                    fileOne.delete();
                    System.out.println("原文件已删除!");
                } catch (Exception e) {
                    System.out.println("原文件删除失败!");
                }
                inOne.close();
                inTwo.close();
            } catch (IOException e) {
                System.out.println("主程序加密出错!");
            }
        } else if (i == 2) {
            encfile = new File("C:/Users/86157/Desktop/enc.two");
            EncodeContext enc = new EncodeContext();
            enc.setStrategy(new StrategyTwo("设计模式"));
            enc.encryptFile(fileOne, encfile);
            System.out.println(fileOne.getName() + "加密方法二加密后内容:");
            try {
                FileReader inOne = new FileReader(encfile);
                BufferedReader inTwo = new BufferedReader(inOne);
                while ((s = inTwo.readLine()) != null) {
                    System.out.println(s);
                }
                try {
                    fileOne.delete();
                    System.out.println("原文件已删除!");
                } catch (Exception e) {
                    System.out.println("原文件删除失败!");
                }
                inOne.close();
                inTwo.close();
            } catch (IOException e) {
                System.out.println("主程序加密出错!");
            }
        } else {
            String str = encfile.getCanonicalPath();
            String hz = str.substring(str.indexOf(".") + 1);
            System.out.println(hz);
            if (hz.equals("one")) {
                EncodeContext encodeContext = new EncodeContext();
                encodeContext.setStrategy(new StrategyOne("设计模式"));
                try {
                    encodeContext.decryptFile(encfile, decfile);
                    System.out.println(encfile.getName() + "使用方法一解密成功");
                } catch (Exception e) {
                    System.out.println("解密失败!");
                }
            } else if (hz.equals("two")) {
                EncodeContext encodeContext = new EncodeContext();
                encodeContext.setStrategy(new StrategyTwo("设计模式"));
                try {
                    encodeContext.decryptFile(encfile, decfile);
                    System.out.println(encfile.getName() + "使用方法二解密成功");
                } catch (Exception e) {
                    System.out.println("解密失败!");
                }
            } else
                System.out.println("非加密文件!");
        }
    }
}
