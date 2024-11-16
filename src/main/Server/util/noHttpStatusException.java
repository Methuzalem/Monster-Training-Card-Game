package main.Server.util;

public class noHttpStatusException extends RuntimeException {
    public noHttpStatusException(String message) {
        super(message);
    }
}
