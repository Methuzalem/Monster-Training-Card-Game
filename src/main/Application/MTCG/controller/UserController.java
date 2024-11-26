package main.Application.MTCG.controller;

import main.Application.MTCG.entity.User;
import main.Application.MTCG.service.UserService;
import main.Server.http.Method;
import main.Server.http.Request;
import main.Server.http.Response;
import main.Server.http.Status;

import java.util.List;

public class UserController extends Controller {

    private final UserService userService = new UserService();

    @Override
    public Response handle(Request request) {

        if (request.getMethod().equals(Method.POST)) {
            return create(request);
        }
        if (request.getMethod().equals(Method.GET)) {
            return readAll();
        }
        return null;
    }

    private Response create(Request request) {

        // request --> student
        User user = fromBody(request.getBody(), User.class);
        user = userService.create(user);

        return json(Status.CREATED, user);
    }

    private Response readAll() {
        List<User> users = userService.getAll();

        return json(Status.OK, users);
    }
}
