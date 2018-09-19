package ServerAndClientWorld;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CapClient {
    public static void main(String[] args) throws Exception {

        //Laver socket til at connect
        Socket socket = new Socket("localhost", 4444);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        //Scanner til at skrive besked
        System.out.println("ENTER:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        //Sender besked
        dos.writeUTF(name);

        //Beskeden den henter
        String incMessage1 = dis.readUTF();
        //Henter player number.
        int playerNumber = dis.readInt();

        //Besked der beskriver hvilke spiller du er.
        System.out.println(incMessage1 + " " + playerNumber);

        System.out.println(dis.readUTF());

        //Spørg om vi er done
        boolean done = false;
        //tæller
        int i = 1;

        //Boolean der beskriver hvis tur det er
        boolean yourturn = false;

        //Hvis man er p1 starter man med turen
        if (playerNumber == 1) {
            yourturn = true;
        }

        //kører imens spillet kører
        while (!done) {

            String namwe = " ";

            //Hvis det er din tur, kan du skrive beskeder
            if (yourturn) {
                System.out.println("Skriv din besked ");
                namwe = scanner.nextLine();
                dos.writeByte(i);
                dos.writeUTF(namwe);
                dos.flush();
                System.out.println(dis.readUTF());
                //Ændrer det til ikke at være din tur.
                yourturn = !yourturn;
            } else {
                System.out.println(dis.readUTF());
                //Ændrer det til ikke at være din tur.
                yourturn = !yourturn;
            }


            i++;


        }


    }

}
