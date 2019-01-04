package com.lxy.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(100);

            int count = 0;

            while (true){
                Socket s = serverSocket.accept();
                ServerThread st = new ServerThread(s);
                Thread th = new Thread(st);

                th.start();

                System.out.println("连接的客户端数：" + (++count) + ",客户端的Ip: " + s.getInetAddress().getHostAddress());

   /*             System.out.println("获取客户端数据：" + new BufferedReader(new InputStreamReader(s.getInputStream())).readLine());

                Thread.sleep(1000*10);
                PrintStream ps = new PrintStream(s.getOutputStream());

                ps.println("您好，收到服务器的请求");
                ps.flush();
                ps.close();
                s.close();*/
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
