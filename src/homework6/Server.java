package homework6;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;


public class Server {
    private final String address;
    private final int port;


    public Server(String address, int port) {
        this.address = address;
        this.port = port;
    }

    /**
     * Method for create connection by address and port number.
     *
     * @throws IOException
     */
    public void connect() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(address, port), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(new Handler());
        server.start();
    }
}
