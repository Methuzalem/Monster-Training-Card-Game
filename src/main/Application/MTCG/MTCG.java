package main.Application.MTCG;

import main.Application.MTCG.repository.UserMemoryRepository;
import main.Application.MTCG.repository.UserRepository;
import main.Server.Application;
import main.Application.MTCG.controller.Controller;
import main.Application.MTCG.controller.UserController;
import main.Application.MTCG.exception.ControllerNotFoundException;
import main.Application.MTCG.routing.Router;
import main.Server.http.Request;
import main.Server.http.Response;
import main.Server.http.Status;

public class MTCG implements Application {

    private final Router router;
    //for data storing
    public final UserRepository userRepository;

    public MTCG() {
        this.router = new Router();
        this.userRepository = new UserMemoryRepository();

        this.initializeRoutes();
    }

    @Override
    public Response handle(Request request) {

        try {
            Controller controller
                    = this.router.getController(request.getPath());
            return controller.handle(request);

        } catch (ControllerNotFoundException e) {
            Response response = new Response();
            response.setStatus(Status.NOT_FOUND);

            response.setHeader("Content-Type", "application/json");
            response.setBody(
                    "{\"error\": \"Path: %s not found\" }"
                            .formatted(e.getMessage())
            );

            return response;
        }
    }

    private void initializeRoutes() {
        this.router.addRoute("/users", new UserController(userRepository));
    }
}
