package main.Application.MTCG.service;


import main.Application.MTCG.entity.User;
import main.Application.MTCG.exception.EntityNotFoundException;
import main.Application.MTCG.repository.UserMemoryRepository;
import main.Application.MTCG.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserMemoryRepository();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.find(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class.getName(), id));
    }
}
