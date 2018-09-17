package Server;

import java.io.DataOutputStream;
import java.net.Socket;

public class ServerSend {
    public void suckit(String message) throws Exception {
        Socket socket = new Socket("127.0.0.1", 2020); // Create and connect the socket

        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

        // Send first message
        dOut.writeByte(1);
        dOut.writeUTF(message);
        dOut.flush(); // Send off the data

        dOut.close();



    }
}
