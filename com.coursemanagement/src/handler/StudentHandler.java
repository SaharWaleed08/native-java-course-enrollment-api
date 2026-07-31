package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dto.request.RegisterStudentRequest;
import dto.response.StudentResponse;
import repository.InMemoryStudentRepository;
import repository.StudentRepository;
import service.StudentService;
import util.HttpUtil;
import util.JsonUtil;

import java.io.IOException;
import java.util.UUID;

public class StudentHandler implements HttpHandler {

    private final StudentService studentService;

    public StudentHandler() {
        StudentRepository studentRepository = new InMemoryStudentRepository();
        this.studentService = new StudentService((InMemoryStudentRepository) studentRepository);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String method = HttpUtil.getMethod(exchange);
        String body = HttpUtil.readRequestBody(exchange);

        switch (method) {

            case "GET":
                UUID id = UUID.fromString(HttpUtil.getId(exchange));
                StudentResponse response = studentService.findStudentByID(id);
                HttpUtil.sendJson(exchange, 200, response.toString());

                break;

            case "POST":
                String fullName = JsonUtil.readString(body, "fullName");
                String email = JsonUtil.readString(body, "email");
                String password = JsonUtil.readString(body, "password");
                StudentResponse response1 = studentService.registerStudent(new RegisterStudentRequest(fullName, email, password));
                HttpUtil.sendJson(exchange, 201, response1.toString());

                break;
            case "DELETE":
                UUID id1 = UUID.fromString(HttpUtil.getId(exchange));
                studentService.deleteById(id1);
                HttpUtil.sendNoContent(exchange);
                break;

            default:
                HttpUtil.sendError(exchange, 405, "Method Not Allowed");
        }
    }
}