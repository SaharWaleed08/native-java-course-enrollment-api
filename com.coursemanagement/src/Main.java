import handler.HttpServerManager;

public class Main {
    public static void main(String[] args) {
        HttpServerManager httpServerManager=new HttpServerManager();
        httpServerManager.start();
    }
}