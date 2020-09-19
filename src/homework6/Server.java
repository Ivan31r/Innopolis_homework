package homework6;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {
    private final String address;
    private final int port;


    public Server(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void connect() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(address, port), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(exchange -> {

            String request = exchange.getRequestMethod();
            String fileName = exchange.getRequestURI().toString().substring(1);

//            System.out.println("Hello");
            if ("GET".equals(request) && Files.isDirectory(Paths.get(fileName))) {
                exchange.sendResponseHeaders(200, "\nSuccessful request".getBytes().length);
                exchange.getResponseBody().write("\nSuccessful request".getBytes());
                printAllFiles(request);
            } else {
                System.out.println("Exception");
                exchange.sendResponseHeaders(404, "\nError 404".getBytes().length);
                exchange.getResponseBody().write("\nError 404".getBytes());
//                throw new IOException(String.valueOf(404));
            }
        });
        server.start();
    }

    private void printAllFiles(String filename) {
        File file = new File(filename);
        for (File files : file.listFiles()) {
            System.out.println((files.isFile() ? "File : " : "Directory : ") + files.getName());
        }
    }


    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }
}
