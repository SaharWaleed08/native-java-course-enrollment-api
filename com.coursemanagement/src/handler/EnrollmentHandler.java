package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dto.request.CreateEnrollmentRequest;
import dto.request.CreatePaymentRequest;
import dto.response.EnrollmentResponse;
import dto.response.PaymentResponse;
import model.PaymentMethod;
import repository.EnrollmentRepository;
import repository.InMemoryEnrollmentRepository;
import service.EnrollmentService;
import util.HttpUtil;
import util.JsonUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

public class EnrollmentHandler implements HttpHandler {
    private final EnrollmentService enrollmentService;
    public EnrollmentHandler(){
        EnrollmentRepository enrollmentRepository=new InMemoryEnrollmentRepository();
        this.enrollmentService=new EnrollmentService((InMemoryEnrollmentRepository) enrollmentRepository);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = HttpUtil.getMethod(exchange);
        String body = HttpUtil.readRequestBody(exchange);

        switch (method) {

            case "GET":
                UUID id = UUID.fromString(HttpUtil.getId(exchange));
                EnrollmentResponse response=enrollmentService.findEnrollmentById(id);
                HttpUtil.sendJson(exchange,200,response.toString());
                break;

            case "POST":
                UUID studentId=UUID.fromString(JsonUtil.readString(body,"studentId"));
                UUID courseId=UUID.fromString(JsonUtil.readString(body,"courseId"));
                CreateEnrollmentRequest request=new CreateEnrollmentRequest(studentId,courseId);
                response=enrollmentService.enrollStudent(request);
                HttpUtil.sendJson(exchange,201,response.toString());

                break;
            case "DELETE":
                id = UUID.fromString(HttpUtil.getId(exchange));
                enrollmentService.deleteEnrollment(id);
                HttpUtil.sendNoContent(exchange);
                break;

            default:
                HttpUtil.sendError(exchange, 405, "Method Not Allowed");
        }
    }
}
