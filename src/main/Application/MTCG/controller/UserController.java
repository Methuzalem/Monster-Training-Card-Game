package main.Application.MTCG.controller;

import main.Application.MTCG.entity.User;
import main.Application.MTCG.repository.UserRepository;
import main.Application.MTCG.service.UserService;
import main.Server.http.Method;
import main.Server.http.Request;
import main.Server.http.Response;
import main.Server.http.Status;

import java.util.List;
import java.util.Optional;

public class UserController extends Controller {

    private final UserService userService;

    public UserController(UserRepository userRepo) {
        this.userService = new UserService(userRepo);
    }

    @Override
    public Response handle(Request request) {

        if (request.getMethod().equals(Method.POST)) {
            return create(request);
        }
        if (request.getMethod().equals(Method.GET)) {
            return readAll(request);
        }
        return null;
    }

    private Response create(Request request) {

        User user = fromBody(request.getBody(), User.class);
        user = userService.create(user);

        return json(Status.CREATED, user);
    }

    private Response readAll(Request request) {
        String[] pathParts = request.getPath().split("/");
        String name = pathParts[1];

        Optional<User> users = userService.getUserByName(name);

        return json(Status.OK, users);
    }
}
