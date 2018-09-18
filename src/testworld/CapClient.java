package testworld;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CapClient {
    public static void main(String[] args) throws Exception {



        Socket socket = new Socket("localhost", 4444);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        System.out.println("ENTER:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        dos.writeUTF(name);

        System.out.println(dis.readUTF()+"1");

        System.out.println(dis.readUTF()+"2");



        //MATHIAS KODE
        boolean done = false;
        int i = 1;
        while(!done) {

            System.out.println("Skriv din besked ");
            String namwe = scanner.nextLine();
            dos.writeByte(i);
            dos.writeUTF(namwe);
            dos.flush();
            System.out.println(dis.readUTF());


            if (namwe.contains("done")){
                System.out.println("Client lukker");
                dos.close();
            }
            i++;
        }

    }

}
