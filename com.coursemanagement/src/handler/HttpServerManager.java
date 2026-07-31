package handler;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerManager {
    static HttpServer server;

    static {
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/api/students",new StudentHandler());
            server.createContext("/api/courses",new CourseHandler());
            server.createContext("/api/auth",new AuthHandler());
            server.createContext("/api/enrollments",new EnrollmentHandler());
            server.createContext("/api/payments",new PaymentHandler());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void start() {
        server.start();
        System.out.println("Server started on port 8080");
    }

}
