package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dto.request.CreateCourseRequest;
import dto.request.RegisterStudentRequest;
import dto.response.CourseResponse;
import dto.response.StudentResponse;
import repository.CourseRepository;
import repository.InMemoryCourseRepository;
import service.CourseService;
import util.HttpUtil;
import util.JsonUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

public class CourseHandler implements HttpHandler {
    private final CourseService courseService;

    public CourseHandler() {
        CourseRepository courseRepository = new InMemoryCourseRepository();
        this.courseService = new CourseService((InMemoryCourseRepository) courseRepository);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String method = HttpUtil.getMethod(exchange);
        String body = HttpUtil.readRequestBody(exchange);

        switch (method) {

            case "GET":
                UUID id = UUID.fromString(JsonUtil.readString(body, "id"));
                CourseResponse response = courseService.findCourseById(id);
                HttpUtil.sendJson(exchange, 200, response.toString());
                break;

            case "POST":
                String title = JsonUtil.readString(body, "title");
                String description = JsonUtil.readString(body, "description");
                BigDecimal price = JsonUtil.readDecimal(body, "price");
                int capacity = JsonUtil.readInt(body, "capacity");
                CourseResponse courseResponse = courseService.createCourse(new CreateCourseRequest(title, description, price, capacity));
                HttpUtil.sendJson(exchange, 201, courseResponse.toString());
                break;

            default:
                HttpUtil.sendError(exchange, 405, "Method Not Allowed");
        }
    }
}
