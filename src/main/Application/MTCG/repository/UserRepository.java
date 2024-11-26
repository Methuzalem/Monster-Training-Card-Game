package main.Application.MTCG.repository;

import main.Application.MTCG.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    Optional<User> find(int id);

    User delete(User user);
}
