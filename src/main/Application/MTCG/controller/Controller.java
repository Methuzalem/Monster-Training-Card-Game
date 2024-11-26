package main.Application.MTCG.controller;

import main.Application.MTCG.exception.InvalidBodyException;
import main.Application.MTCG.exception.JsonParserException;
import main.Server.http.Request;
import main.Server.http.Response;
import main.Server.http.Status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Controller {

    private final ObjectMapper objectMapper;

    public Controller() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(
                MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true
        );
    }

    public abstract Response handle(Request request);


    protected <T> T fromBody(String body, Class<T> type) {
        try {
            return objectMapper.readValue(body, type);
        } catch (JsonProcessingException e) {
            throw new InvalidBodyException(e);
        }
    }

    protected Response json(Status status, Object object) {
        Response response = new Response();
        response.setStatus(status);
        response.setHeader("Content-Type", "application/json");
        try {
            response.setBody(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            throw new JsonParserException(e);
        }

        return response;
    }
}
