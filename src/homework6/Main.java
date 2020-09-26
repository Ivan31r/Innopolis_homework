package homework6;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server("localhost", 8080);
        try {
            server.connect();
        } catch (IOException e) {
            System.out.println("Connect was failed");
        }
    }
}
