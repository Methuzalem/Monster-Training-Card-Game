package main.Application.MTCG.repository;

import main.Application.MTCG.entity.User;
import main.Application.MTCG.exception.usersEXCPT.InvalidUserData;
import main.Application.MTCG.exception.usersEXCPT.UsernameNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserMemoryRepository implements UserRepository {

    private final List<User> users;

    public UserMemoryRepository() {

        this.users = new ArrayList<>();
    }

    @Override
    public User save(User user) {
        user.setToken("%s-MTCGToken".formatted(user.getUsername()));
        this.users.add(user);

        return user;
    }

    @Override
    public Optional<User> findUserByName(String username){

        for(User user : this.users){
            if(user.getUsername().equals(username)){
                return Optional.of(user);
            }

        }
        throw new UsernameNotFound("Username: '" + username + "' couldn't been found.");
    }

    @Override
    public Optional<User> loginCheck(String username, String password) {
        for(User user : this.users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return Optional.of(user);
            }
        }
        throw new InvalidUserData("Invalid username or password");
    }

    @Override
    public User delete(User user) {

        return null;
    }
}