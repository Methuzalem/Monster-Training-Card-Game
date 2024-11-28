package main.Application.MTCG.repository;

import main.Application.MTCG.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findUserByName(String username);

    Optional<User> loginCheck(String username, String password);

    User delete(User user);
}
