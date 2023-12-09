// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.net.ServerSocket;
// import java.net.Socket;
// import java.util.Scanner;

// public class chat_server {
//     public static void main(String[] args) {
//         System.out.println("Server ready to connect !!");
//         try
//         {
//             ServerSocket server     = new ServerSocket(12345);
//             Socket connection       = server.accept();
//             Scanner sc = new Scanner(System.in);
//             ObjectInputStream inp   = new ObjectInputStream(connection.getInputStream());
//             ObjectOutputStream outp = new ObjectOutputStream(connection.getOutputStream());
//             String msg_sent,msg_recieved;
//             while(true)
//             {
//                 System.out.print("You : ");
//                 msg_sent = sc.nextLine();
//                 if(msg_sent.toLowerCase().equals("over"))
//                 {
//                     System.out.println("Chat closed!!");
//                     sc.close();
//                     inp.close();
//                     outp.close();
//                     server.close();
//                     connection.close();
//                     System.exit(0);
//                 }
//                 else
//                 {
//                     outp.writeObject(msg_sent);
//                 }
//                 msg_recieved = (String)inp.readObject();
//                 System.out.println("Client : "+msg_recieved);
//             }
//         }
//         catch(Exception e)
//         {
//                 System.out.println(e);
//         }
//     }
// }
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class chat_server {
    public static void main(String[] args) {
        System.out.println("Server ready to connect!!");
        try {
            ServerSocket server = new ServerSocket(12345);
            Socket connection = server.accept();
            Scanner sc = new Scanner(System.in);
            ObjectOutputStream outp = new ObjectOutputStream(connection.getOutputStream());
            ObjectInputStream inp = new ObjectInputStream(connection.getInputStream());

            String msgSent, msgReceived;
            while (true) {
                System.out.print("You: ");
                msgSent = sc.nextLine();

                if (msgSent.toLowerCase().equals("over")) {
                    System.out.println("Chat closed!!");
                    sc.close();
                    outp.close();
                    inp.close();
                    server.close();
                    connection.close();
                    System.exit(0);
                } else {
                    outp.writeObject(msgSent);
                }

                msgReceived = (String) inp.readObject();
                System.out.println("Client: " + msgReceived);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

