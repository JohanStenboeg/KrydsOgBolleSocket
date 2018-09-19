package testworld;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CapServer implements Runnable {
    static final int PORT= 4444;

    public static void main(String[] args) throws  Exception {
        ServerSocket serverSocket = new ServerSocket(PORT,2);

        System.out.println("Server is running!");
        System.out.println("Waiting for 1 st player");

        Socket socket1 = serverSocket.accept();
        DataOutputStream dos1 = new DataOutputStream(socket1.getOutputStream());
        DataInputStream dis1 = new DataInputStream(socket1.getInputStream());

        String playername1 = dis1.readUTF();
        dos1.writeUTF("hello "+ playername1+" and welcome, youre player");
        //player number
        dos1.writeInt(1);

        System.out.println("Server accepted " + playername1);
        System.out.println("Server is waiting for next opponent");

        Socket socket2 = serverSocket.accept();
        System.out.println("socket2 accepted");
        DataOutputStream dos2 = new DataOutputStream(socket2.getOutputStream());
        DataInputStream dis2 = new DataInputStream(socket2.getInputStream());

        String playername2 = dis2.readUTF();
        dos2.writeUTF("hello "+ playername2+" and welcome, youre player");
        dos2.writeInt(2);

        System.out.println("Server accepted " + playername2);


        dos1.writeUTF("You can start:");
        dos2.writeUTF("Wait for player 1 to make his move : ");

        int counter = 1;
        int whosturn = 1;
        //MATHIAS KODEs
        boolean done = false;
        while(!done) {





            if (counter % 2 == 0) {
                System.out.println("player 2 turn");
                whosturn=2;
            }else{
                System.out.println("PLayer one turn");
                whosturn=1;
            }

            if(whosturn ==1){
                byte messageType = dis1.readByte();
            }else{
                byte messageType2 = dis2.readByte();
            }
                    System.out.println("stopper den her? ");
                try {
                String line = "fejl";
                if(whosturn == 2) {
                    line = dis2.readUTF();
                    System.out.println("tst"+line);
                }else{
                    line = dis1.readUTF();
                    System.out.println(line);
                }
                    //done = line.equals("done");
                    if(whosturn == 2) {
                        dos2.writeUTF("Serveren har modtaget dit svar : " + line);
                        dos1.writeUTF("Serveren har modtaget den andens svar : " + line);
                    }else{
                        dos1.writeUTF("Serveren har modtaget dit svar : " + line);
                        dos2.writeUTF("Serveren har modtaget den andens svar : " + line);
                    }


                    counter++;
                    //Prøv AT SKRIV DET ANDET HER:

                } catch (Exception e) {
                    System.out.println("fejl");
                    //done = true;
                }


                try {
                    //String line2 = dis2.readUTF();
                    //System.out.println(line2);
                    //done = line2.equals("done");
                    //dos2.writeUTF("Serveren har modtaget dit svar : " + line2);

                } catch (Exception e) {
                    System.out.println("fejl");
                    //done = true;
                }

            }






    }

    @Override
    public void run() {

    }
}
