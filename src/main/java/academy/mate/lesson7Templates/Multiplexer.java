package academy.mate.lesson7Templates;

import java.util.HashMap;
import java.util.Map;

import static academy.mate.lesson7Templates.Factory.getAddUserHandler;
import static academy.mate.lesson7Templates.Factory.getGetAllUsersHandler;
import static academy.mate.lesson7Templates.Factory.getPageNotFoundHandler;

public class Multiplexer {

    private final static Map<Request, BaseHandler> handlers = new HashMap<>();

    static {
        handlers.put(Request.of("GET", "/users"), getGetAllUsersHandler());
        handlers.put(Request.of("POST", "/users"), getAddUserHandler());
    }

    public void doSomething(String method, String uri) {
        Request request = new Request(method, uri);
        BaseHandler handler = handlers.getOrDefault(request, getPageNotFoundHandler());
        handler.doSomething(request);
    }
}
