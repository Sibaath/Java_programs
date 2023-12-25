import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.InetAddress;
import java.net.Socket;

import java.util.Scanner;

public class main11 {
    public static void main(String[] args) {
        try {
            Socket clientConnection = new Socket(InetAddress.getLocalHost(), 12345);
            ObjectOutputStream output = new ObjectOutputStream(clientConnection.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(clientConnection.getInputStream());
            String str=new String();
            Scanner scan=new Scanner(System.in);
            String message=new String();
            do
            {
                System.out.print("You: ");
                str=scan.nextLine();
                if(str.toLowerCase().equals("over"))
                {
                    clientConnection.close();
                    exit(0);
                }
                output.writeObject(str);
                message=(String) input.readObject();
                System.out.println("Server: "+message);
            }while(!(message.equals("over")));
            clientConnection.close();
            output.close();
            input.close();
            scan.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        
        
    }

    private static void exit(int i) {
    }
}