import java.io.*;
import java.util.*;
import java.net.*;
import java.awt.*;
public class main10{
    public static void main(String[] args) {
        System.out.println("Server is Started!\nServer is Waiting for a client\n");
        try {
            ServerSocket server=new ServerSocket(12345);
            Socket connection=server.accept();
            ObjectOutputStream output=new ObjectOutputStream(connection.getOutputStream());
            ObjectInputStream input=new ObjectInputStream(connection.getInputStream());
            System.out.println("Server accepted the client request");
            String message;
            do
            {
                message=(String) input.readObject();
                if(message.toLowerCase().equals("over"))
            {
                connection.close();
                System.exit(0);
            }
                System.out.println("Client: "+ message);
                System.out.print("You: ");
                Scanner scan =new Scanner(System.in);
                String str=scan.nextLine();
                output.writeObject(str);
            }while(!message.equals("over"));
            connection.close();
            output.close();
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}