package academy.mate.lesson7Templates;

import java.util.HashMap;
import java.util.Map;

public class Multiplexer {

    private final static Map<Request, BaseHandler> handlesr = new HashMap<>();

    static {
        handlesr.put(new Request("GET", "/users"), new GetAllUsersHandler());
        handlesr.put(new Request("POST", "/users"), new AddUserHandler());
    }


}
