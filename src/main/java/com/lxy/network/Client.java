package com.lxy.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",100);
            Scanner scanner = new Scanner(System.in);

            System.out.println("请输入你的内容:");
            String mes = scanner.nextLine();

            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(mes);
            ps.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            System.out.println(line);
            br.close();
            ps.close();
            socket.close();

            } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
