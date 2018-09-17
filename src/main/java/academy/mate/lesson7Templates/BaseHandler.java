package academy.mate.lesson7Templates;

import java.util.List;

public abstract class BaseHandler {
    public void doSomething(String method, String uri) {
        Request request = new Request();
        doSomething(method, uri, request);
    }

    protected abstract void doSomething(String method, String uri, Request request);

    class Request {
        List<Object> params;
    }

}
