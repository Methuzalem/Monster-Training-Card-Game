package main.Server;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

import main.Server.http.Request;
import main.Server.http.Response;
import main.Server.util.HttpRequestParser;
import main.Server.util.HttpResponseFormatter;
import main.Server.util.HttpSocket;

public class RequestHandler {

    private final Socket socket;
    private final Application application;

    public RequestHandler(
            Socket socket,
            Application application
    ) {
        this.socket = socket;
        this.application = application;
    }

    public void handle() {
        HttpRequestParser httpRequestParser = new HttpRequestParser();
        HttpResponseFormatter httpResponseFormatter = new HttpResponseFormatter();

        try (HttpSocket httpSocket = new HttpSocket(this.socket)) {
            String http = httpSocket.read();
            Request request = httpRequestParser.parse(http);

            System.out.printf(
                    "%s %s %s\n", LocalDateTime.now() , request.getMethod(), request.getPath()
            );

            Response response = this.application.handle(request);

            http = httpResponseFormatter.format(response);
            httpSocket.write(http);
        } catch (IOException e) {

            // send standard error response

            throw new RuntimeException(e);
        }
    }
}
