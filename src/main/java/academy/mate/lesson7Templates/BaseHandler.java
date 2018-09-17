package academy.mate.lesson7Templates;

import java.util.List;

public abstract class BaseHandler {
    public void doSomething(String method, String uri) {
        Request request = new Request();
        doSomething(method, uri, request);
    }

    protected void doSomething(String method, String uri, Request request) {
        if (method.equals("POST") && uri.equals("/users")) { //процедурный стиль когда несколько if

        } else if (!request.smth) {
        }
    }

    class Request {
        List<Object> params;
        private boolean smth;
    }

}
