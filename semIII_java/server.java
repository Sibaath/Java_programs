package semIII_java;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(12345);
            Socket clientsocket = server.accept();
            ObjectOutputStream output = new ObjectOutputStream(clientsocket.getOutputStream());
            int a = 10;
            output.writeObject(a);
            output.close();
            clientsocket.close();
            server.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }
}
