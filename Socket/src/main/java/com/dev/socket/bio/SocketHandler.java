package com.dev.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler implements Runnable {
    private Socket socket;

    public SocketHandler(Socket socket){
        this.socket = socket;
    }
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try{
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            String body = "";

            while (true){
                body = reader.readLine();
                if(body == null){
                    break;
                }
                writer.println(body);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(writer != null){
                writer.close();
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
