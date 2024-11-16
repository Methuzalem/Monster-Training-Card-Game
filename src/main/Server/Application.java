package main.Server;

import main.Server.http.Response;
import main.Server.http.Request;

public interface Application {
    Response handle(Request request);
}
