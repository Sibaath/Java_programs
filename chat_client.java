// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.net.Socket;
// import java.util.Scanner;

// public class chat_client {
//     public static void main(String[] args) {
//         try{
//             Socket client = new Socket("127.0.0.1",12345);
//             Scanner sc = new Scanner(System.in);
//             ObjectInputStream inp   = new ObjectInputStream(client.getInputStream());
//             ObjectOutputStream outp = new ObjectOutputStream(client.getOutputStream());
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
//                     client.close();
//                     System.exit(0);
//                 }
//                 else
//                 {
//                     outp.writeObject(msg_sent);
//                 }
//                 msg_recieved = (String)inp.readObject();
//                 System.out.println("Server : "+msg_recieved);
//             }
//         }
//         catch(Exception e)
//         {
//             System.out.println(e);
//         }
//     }
// }
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class chat_client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 12345);
            Scanner sc = new Scanner(System.in);
            ObjectOutputStream outp = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream inp = new ObjectInputStream(client.getInputStream());

            String msgSent, msgReceived;
            while (true) {
                msgReceived = (String) inp.readObject();
                System.out.println("Server: " + msgReceived);
                System.out.print("You: ");
                msgSent = sc.nextLine();

                if (msgSent.toLowerCase().equals("over")) {
                    System.out.println("Chat closed!!");
                    sc.close();
                    outp.close();
                    inp.close();
                    client.close();
                    System.exit(0);
                } else {
                    outp.writeObject(msgSent);
                }

            }
        } catch (Exception e) {
            System.out.println("Chat Closed");
        }
    }
}