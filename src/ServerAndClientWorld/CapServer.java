package ServerAndClientWorld;

import TicTacToeBackend.Logik;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CapServer {
    //Hvilken port vi skal køre på.
    static final int PORT = 4444;

    public static void main(String[] args) throws Exception {
        //Åbner socket på PORT
        ServerSocket serverSocket = new ServerSocket(PORT, 2);

        //Info i server terminal
        System.out.println("Server is running!");
        System.out.println("Waiting for 1 st player");

        //Acceptere socket, samt laver Data(out/in) for første player1.
        Socket socket1 = serverSocket.accept();
        DataOutputStream dos1 = new DataOutputStream(socket1.getOutputStream());
        DataInputStream dis1 = new DataInputStream(socket1.getInputStream());

        //Henter players navn og return en message der fortæller ham det.
        String playername1 = dis1.readUTF();
        dos1.writeUTF("hello " + playername1 + " aka. X and welcome, youre player");
        //tildeler player number
        dos1.writeInt(1);

        //Info i server terminal
        System.out.println("Server accepted " + playername1);
        System.out.println("Server is waiting for next opponent");

        //Acceptere socket, samt laver Data(out/in) for anden player.
        Socket socket2 = serverSocket.accept();
        DataOutputStream dos2 = new DataOutputStream(socket2.getOutputStream());
        DataInputStream dis2 = new DataInputStream(socket2.getInputStream());

        //Henter hans navn og sender velkomst besked
        String playername2 = dis2.readUTF();
        dos2.writeUTF("hello " + playername2 + " aka. O and welcome, youre player");
        //tildeler player number
        dos2.writeInt(2);
        //info til server
        System.out.println("Server accepted " + playername2);

        //Fortæller p1 at han kan starte og p2 at han skal vente.
        dos1.writeUTF("You can start:");
        dos2.writeUTF("Wait for player 1 to make his move : ");



        /*
        * SPILLET STARTER
        * */

        Logik logik = new Logik();

        //Counter der tæller hvis tur det er.
        int counter = 1;
        //Hvilken players tur det er, 1 eller 2.
        int whosturn = 1;
        //Om spillet er igang eller ej.
        boolean done = false;
        //While loop, der kører mens spillet er igang.
        while (!done) {
            //Vælger hvis tur det er
            if (counter % 2 == 0) {
                System.out.println("player 2 turn");
                whosturn = 2;
            } else {
                System.out.println("PLayer 1 turn");
                whosturn = 1;
            }

            //Henter byte efter hvis tur det er.
            if (whosturn == 1) {
                byte messageType = dis1.readByte();
            } else {
                byte messageType2 = dis2.readByte();
            }

            String printeren = " ";

            //try catch til at hente og sende data med dos og dis
            try {
                //line der printer fejl, hvis den ikke bliver tildelt en anden værdi
                int line ;

                //Depending on hvis tur det er, henter den en string og souter
                if (whosturn == 2) {
                    line = dis2.readInt();
                    printeren = logik.play(line,false);
                    System.out.println("Player 2: "+line);
                    System.out.println(printeren);
                } else {
                    line = dis1.readInt();
                    printeren = logik.play(line,true);
                    System.out.println("Player 1: "+line);
                    System.out.println(printeren);
                }

                //Printer hvad den anden har skrevet
                if (whosturn == 2) {
                    //RETURN TICPRINT HER TIL BEGGET

                    dos2.writeUTF(printeren);
                    dos1.writeUTF(printeren);

                    //dos2.writeUTF("Serveren har modtaget dit svar : " + line);
                    //dos1.writeUTF("Serveren har modtaget den andens svar : " + line);
                } else {
                    //OGSÅ HER


                    dos2.writeUTF(printeren);
                    dos1.writeUTF(printeren);

//                    dos1.writeUTF("Serveren har modtaget dit svar : " + line);
  //                  dos2.writeUTF("Serveren har modtaget den andens svar : " + line);
                }

                //tæller en til counter
                counter++;

                //Catcher evt. fejl hvis den ikke connector
            } catch (Exception e) {
                System.out.println("fejl");
            }

        }


    }

}
