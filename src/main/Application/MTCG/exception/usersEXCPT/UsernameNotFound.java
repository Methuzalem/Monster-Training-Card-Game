package main.Application.MTCG.exception.usersEXCPT;

public class UsernameNotFound extends RuntimeException {
    public UsernameNotFound(String message) {
        super(message);
    }
}
