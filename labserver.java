package prg_java;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class labserver {
    public static void main(String[] args) {
        try
        {
            ServerSocket server = new ServerSocket(12345);
            Socket connection = server.accept();
            ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
            String message = (String)input.readObject();
            System.out.println("The message from client is : "+message);
            output.writeObject("Yes i got your request-by server");
            connection.close();
            server.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
}
