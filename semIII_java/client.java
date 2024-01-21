package semIII_java;

import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try
        {
            Socket client = new Socket("127.0.0.1",12345);
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            int a = (int)input.readObject();
            System.out.println(a);
            input.close();
            client.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
