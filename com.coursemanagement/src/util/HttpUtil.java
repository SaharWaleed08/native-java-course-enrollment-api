package util;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpUtil {
    public static String readRequestBody(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        String body = new String(is.readAllBytes());
        return body;

    }

    public static void sendJson(HttpExchange exchange, int statuscode, String json) throws IOException {
        setJsonHeader(exchange);

        byte[] response = json.getBytes(StandardCharsets.UTF_8);

        exchange.sendResponseHeaders(statuscode, response.length);

        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();

    }

    public static void sendNoContent(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(204, -1);
        exchange.close();

    }

    public static void sendError(HttpExchange exchange, int statusCode, String message) throws IOException {
        JsonUtil jsonUtil = new JsonUtil();

        String error = jsonUtil.errorJson(message);

        sendJson(exchange, statusCode, error);
    }

    public static String getMethod(HttpExchange exchange) {
        String method = exchange.getRequestMethod();
        return method;

    }

    public static String getPath(HttpExchange exchange) {
        String path = String.valueOf(exchange.getRequestURI().getPath());
        return path;

    }

    public static Map<String, String> getQueryParams(HttpExchange exchange) {
        Map<String, String> params = new HashMap<>();
        String query = String.valueOf(exchange.getRequestURI().getQuery());
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            params.put(keyValue[0],keyValue[1] );
        }


        return params;

    }

    public static void setJsonHeader(HttpExchange exchange) {
        exchange.getResponseHeaders().set(
                "Content-Type",
                "application/json; charset=UTF-8"
        );
    }
}
