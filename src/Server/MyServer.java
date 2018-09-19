package Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;



public class MyServer  {

    public static void main(String[] args) throws Exception {



        System.out.println("Hello World!");
        ServerSocket s = new ServerSocket(2020);
        System.out.println("Server waiting for connection....");

        Socket so = s.accept();
        System.out.println("Connection Established");

        DataInputStream dIn = new DataInputStream(so.getInputStream());
        DataOutputStream dOut = new DataOutputStream(so.getOutputStream());



        boolean done = false;

        while(!done)
        {

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

    }
}