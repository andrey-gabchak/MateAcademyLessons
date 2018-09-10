package academy.mate.lesson6Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static List<Main.User> userList = new ArrayList<>();

    static {
        userList.add(new Main.User("lucky7", "l7@test.com", 13));
        userList.add(new Main.User("lucky8", "l8@test.com", 14));
        userList.add(new Main.User("lucky9", "l9@test.com", 16));
    }

    public Main.User addUser(Main.User user) {
        this.userList.add(user);
        return user;
    }

    public Main.User findByEmail(String email) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .get();
    }
}
