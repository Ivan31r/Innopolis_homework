package homework6;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Handler implements HttpHandler {
    @Override
    /**
     * Handler for handling request from client.
     * In successful case will shown all files and packages
     */
    public void handle(HttpExchange exchange) throws IOException {
        String request = exchange.getRequestMethod();
        String fileName = exchange.getRequestURI().toString().substring(1);

        if ("GET".equals(request) && Files.isDirectory(Paths.get(fileName))) {
            exchange.sendResponseHeaders(200, getFilesAndDirectory("./").getBytes().length);
            exchange.getResponseBody().write(getFilesAndDirectory("./").getBytes());
        } else {
            System.out.println("Exception");
            exchange.sendResponseHeaders(404, "\nError 404".getBytes().length);
            exchange.getResponseBody().write("\nError 404".getBytes());
        }
    }

    private String getFilesAndDirectory(String path) {
        StringBuilder builder = new StringBuilder();
        File file = new File(path);
        for (File files : file.listFiles()) {
            builder.append(files.isFile() ? "File : " : "Directory : ").append(files.getName()).append("\n");
        }
        return builder.toString();
    }
}
