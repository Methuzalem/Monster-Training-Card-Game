package main.Application.MTCG.service;


import main.Application.MTCG.entity.User;
import main.Application.MTCG.exception.usersEXCPT.UsernameNotFound;
import main.Application.MTCG.exception.usersEXCPT.UsernameExistsAlready;
import main.Application.MTCG.repository.UserMemoryRepository;
import main.Application.MTCG.repository.UserRepository;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserMemoryRepository();
    }

    public User create(User user) {
        if(user == null) {
            throw new NullPointerException("Error: user is NULL");
        }

        Optional<User> existingUser = userRepository.findUserByName(user.getUsername());

        if (existingUser.isPresent()) {
            throw new UsernameExistsAlready("Error: username already exists");
        }

        return userRepository.save(user);
    }

    public User getUserByName(String username) {
        return userRepository.findUserByName(username)
                .orElseThrow(() -> new UsernameNotFound(User.class.getName() + " was not found."));
    }
}
