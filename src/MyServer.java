import java.net.*;

public class MyServer {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        ServerSocket s = new ServerSocket(2020);
        System.out.println("Server waiting for connection....");
        Socket so = s.accept();
        System.out.println("Connection Established");
    }
}