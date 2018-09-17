package academy.mate.lesson7Templates;

public class Factory {

    public static BaseHandler getGetAllUsersHandler() {
        return new GetAllUsersHandler();
    }

    public static BaseHandler getAddUserHandler() {
        return new AddUserHandler();
    }

    public static BaseHandler getPageNotFoundHandler() {
        return new PageNotFoundHandler();
    }
}
