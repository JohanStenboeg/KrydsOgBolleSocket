import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) throws Exception {



        //Socket s = new Socket("127.0.0.1", 2020);




        Socket socket = new Socket("127.0.0.1",2020); // Create and connect the socket
        System.out.println("Connection Established");

        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        DataInputStream dIn = new DataInputStream(socket.getInputStream());

        boolean done = false;
        int i = 1;
        while(!done) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Skriv din besked ");
            String namwe = scanner.nextLine();
            dOut.writeByte(i);
            dOut.writeUTF(namwe);
            dOut.flush();
            System.out.println(dIn.readUTF());



            if (namwe.contains("done")){
                System.out.println("Client lukker");
                dOut.close();
            }
            i++;
        }


// Send first message
       // dOut.writeByte(1);
        //dOut.writeUTF(namwe);
        //dOut.flush(); // Send off the data

// Send the second message
     //   dOut.writeByte(2);
      //  dOut.writeUTF(navn2);
        //dOut.flush(); // Send off the data

// Send the third message
        //dOut.writeByte(3);
        //dOut.writeUTF("This is the third type of message (Part 1).");
        //dOut.writeUTF(navn3);
        //dOut.flush(); // Send off the data

// Send the exit message
        //dOut.writeByte(-1);
        //dOut.flush();


    }
}
