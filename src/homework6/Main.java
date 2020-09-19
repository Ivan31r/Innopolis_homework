package homework6;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
    Server server = new Server("localhost",8080);
    try {
        server.connect();
//        System.out.println("SOUT");
    }catch (IOException e){
        System.out.println("Connect was failed");
    }
    }
}
