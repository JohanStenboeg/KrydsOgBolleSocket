package ServerAndClientWorld;

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

        String incMessage1 = dis.readUTF();
        int playerNumber = dis.readInt();

        System.out.println(incMessage1+" "+playerNumber);

        System.out.println(dis.readUTF()+": message 2");



        //MATHIAS KODEs
        boolean done = false;
        int i = 1;


        boolean yourturn = false;

        if(playerNumber==1){
            yourturn=true;
        }

        while(!done) {

            String namwe = " ";
            if(yourturn) {
                System.out.println("Skriv din besked ");
                namwe = scanner.nextLine();
                dos.writeByte(i);
                dos.writeUTF(namwe);
                dos.flush();
                System.out.println(dis.readUTF());
                yourturn = !yourturn;
            }else{
                System.out.println(dis.readUTF());
                yourturn = !yourturn;
            }

            /*if (namwe.contains("done")){
                System.out.println("Client lukker");
                dos.close();
            }*/

            i++;
            /*
            boolean sleep = true;
            while(!yourturn){
                Thread.sleep(50);
                if(dis.readUTF()=="YourTurn"){
                    yourturn = false;
                }

            }*/


        }


    }

}
