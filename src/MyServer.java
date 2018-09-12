import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.*;

public class MyServer {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        ServerSocket s = new ServerSocket(2020);
        System.out.println("Server waiting for connection....");

        Socket so = s.accept();
        System.out.println("Connection Established");

        System.out.println("message send!!");

        System.out.println("Stops here");
        DataInputStream dIn = new DataInputStream(so.getInputStream());

        boolean done = false;
        while(!done) {
            byte messageType = dIn.readByte();

            switch(messageType)
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
                    done = true;
            }
        }

        dIn.close();
    }
}