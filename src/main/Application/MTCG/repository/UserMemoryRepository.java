package main.Application.MTCG.repository;

import main.Application.MTCG.entity.User;

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
        this.users.add(user);

        return user;
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public Optional<User> find(int id) {
        return Optional.empty();
    }

    @Override
    public User delete(User user) {
        return null;
    }
}