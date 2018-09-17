package academy.mate.lesson7Templates;

public abstract class BaseHandler {
    public void doSomething(String method, String uri) {
        Request request = new Request(method, uri);
        doSomething(request);
    }

    protected abstract void doSomething(Request request);


}
