package semIII_java;

import java.io.*;
import java.net.*;

public class labclient {
    public static void main(String[] args) {
        try
        {
            Socket client_connection = new Socket("127.0.0.1",12345);
            ObjectOutputStream output = new ObjectOutputStream(client_connection.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(client_connection.getInputStream());
            output.writeObject("Hello!A need this HTML page");
            String message = (String)input.readObject();
            System.out.println("The Response from sever is : "+message);
            output.close();
            input.close();
            client_connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }    
}
