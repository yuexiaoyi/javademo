package com.lxy.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable{

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("获取客户端数据：" + new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());

            PrintStream ps = new PrintStream(socket.getOutputStream());

            ps.println("您好，收到服务器的请求");
            ps.flush();
            ps.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
