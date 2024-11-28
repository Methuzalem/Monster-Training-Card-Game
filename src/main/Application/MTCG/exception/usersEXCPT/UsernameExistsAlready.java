package main.Application.MTCG.exception.usersEXCPT;

public class UsernameExistsAlready extends RuntimeException {
    public UsernameExistsAlready(String message) {
        super(message);
    }
}
