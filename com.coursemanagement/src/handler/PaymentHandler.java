package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dto.request.CreatePaymentRequest;
import dto.response.PaymentResponse;
import model.PaymentMethod;
import repository.InMemoryPaymentRepository;
import repository.PaymentRepository;
import service.PaymentService;
import util.HttpUtil;
import util.JsonUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;


public class PaymentHandler implements HttpHandler {
    private final PaymentService paymentService;

    public PaymentHandler() {
        PaymentRepository paymentRepository = new InMemoryPaymentRepository();
        this.paymentService = new PaymentService((InMemoryPaymentRepository) paymentRepository);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = HttpUtil.getMethod(exchange);
        String body = HttpUtil.readRequestBody(exchange);

        switch (method) {

            case "GET":
                UUID id = UUID.fromString(HttpUtil.getId(exchange));
                PaymentResponse response = paymentService.findPaymentById(id);
                HttpUtil.sendJson(exchange, 200, response.toString());
                break;

            case "POST":
                UUID enrollmentId = UUID.fromString(JsonUtil.readString(body, "enrollmentId"));
                BigDecimal amount = JsonUtil.readDecimal(body, "amount");
                PaymentMethod paymentMethod = (PaymentMethod) JsonUtil.readEnum(body, "paymentMethod");
                CreatePaymentRequest request = new CreatePaymentRequest(enrollmentId, amount, paymentMethod);
                response = paymentService.createPayment(request);
                HttpUtil.sendJson(exchange, 201, response.toString());
                break;
            case "DELETE":
                id = UUID.fromString(HttpUtil.getId(exchange));
                paymentService.deletePayment(id);
                HttpUtil.sendNoContent(exchange);
                break;

            default:
                HttpUtil.sendError(exchange, 405, "Method Not Allowed");
        }
    }
}
