package main.Application.MTCG.exception.usersEXCPT;

public class InvalidUserData extends RuntimeException {
    public InvalidUserData(String message) {
        super(message);
    }
}
