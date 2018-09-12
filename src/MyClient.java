import java.net.*;

public class MyClient {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 2020);
        System.out.println("Connection Established");
    }
}
