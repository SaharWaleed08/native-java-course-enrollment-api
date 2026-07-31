package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dto.request.CreateCourseRequest;
import dto.request.UpdateCourseRequest;
import dto.request.UpdateCourseStatusRequest;
import dto.response.CourseResponse;
import model.CourseStatus;
import repository.CourseRepository;
import repository.InMemoryCourseRepository;
import service.CourseService;
import util.HttpUtil;
import util.JsonUtil;

import java.io.BufferedReader;
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
        System.out.println(method);
        String body = HttpUtil.readRequestBody(exchange);

        switch (method) {

            case "GET":
                UUID id = UUID.fromString(HttpUtil.getId(exchange));
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
            case "PUT":
                id = UUID.fromString(HttpUtil.getId(exchange));
                title = JsonUtil.readString(body, "title");
                description = JsonUtil.readString(body, "description");
                price = JsonUtil.readDecimal(body, "price");
                capacity = JsonUtil.readInt(body, "capacity");
                UpdateCourseRequest request = new UpdateCourseRequest(title, description, price, capacity);
                courseResponse = courseService.replaceCourse(id, request);
                HttpUtil.sendJson(exchange, 200, courseResponse.toString());
                break;
            case "PATCH":
                id = UUID.fromString(HttpUtil.getId(exchange));
                UpdateCourseStatusRequest courseStatusRequest = new UpdateCourseStatusRequest((CourseStatus) JsonUtil.readEnum(body, "status"));
                courseResponse = courseService.updateCourseStatus(id, courseStatusRequest);
                HttpUtil.sendJson(exchange, 200, courseResponse.toString());
                break;
            case "DELETE":
                id = UUID.fromString(HttpUtil.getId(exchange));
                courseService.deleteCourse(id);
                HttpUtil.sendNoContent(exchange);
                break;
            default:
                HttpUtil.sendError(exchange, 405, "Method Not Allowed");
        }
    }
}
