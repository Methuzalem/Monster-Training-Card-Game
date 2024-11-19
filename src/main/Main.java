package main;
import main.Application.Echo.EchoApplication;
import main.Server.Server;


public class Main {
    public static void main(String[] args) {
        Server server = new Server(new EchoApplication());
        server.start();
    }
}
