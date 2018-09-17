package Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

public class MyServer {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        ServerSocket s = new ServerSocket(2020);
        System.out.println("Server waiting for connection....");

        Socket so = s.accept();
        System.out.println("Connection Established");

        DataInputStream dIn = new DataInputStream(so.getInputStream());
        DataOutputStream dOut = new DataOutputStream(so.getOutputStream());
        DataOutputStream toClient = new DataOutputStream(so.getOutputStream());


        boolean done = false;
        while(!done) {
            byte messageType = dIn.readByte();

          /*  switch(messageType)
            {
                case 1: // Type A
                    System.out.println("Message A: " + dIn.readUTF());
                    break;
                case 2: // Type B
                    System.out.println("Message B: " + dIn.readUTF());
                    break;
                case 3: // Type C
                    System.out.println("Message C [1]: " + dIn.readUTF());
                    System.out.println("Message C [2]: " + dIn.readUTF());
                    break;
                default:
                    if (dIn.readUTF()== "quit"){
                        done = true;
                    }
            }
*/

         try {
             String line = dIn.readUTF();
             System.out.println(line);
           done = line.equals("done");
           dOut.writeUTF("Serveren har modtaget dit svar : "+ line);

          } catch(Exception e) {
              System.out.println( "fejl");
              done = true;
            }


    }
}             }