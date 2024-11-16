package main;
import main.Application.echo.echoApplication;
import main.Server.Server;


public class Main {
    public static void main(String[] args) {
        Server server = new Server(new echoApplication());
        server.start();
    }
}
