package main.Application.Echo;

import main.Server.Application;
import main.Server.http.Request;
import main.Server.http.Response;
import main.Server.http.Status;

public class EchoApplication implements Application {

    @Override
    public Response handle(Request request) {

        Response response = new Response();
        response.setStatus(Status.OK);
        response.setHeader("Content-Type", "text/plain");
        response.setBody(request.getHttp());

        return response;
    }
}
