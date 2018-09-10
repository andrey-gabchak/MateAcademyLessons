package academy.mate.lesson6Mockito;

import academy.mate.lesson3.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Spy
    private UserDao userDao;
    @Mock
    private EmailService emailService;
    @InjectMocks
    private MainWrapper main = new MainWrapper();

    @Test
    public void testFindUserByEmail_OK() {
        Main.User user = new Main.User("lucy", "lucy@test.com", 20);
        when(userDao.findByEmail(anyString())).thenReturn(user); //.thenReturn(null)
        Main.User expected = new Main.User("lucy", "lucy@test.com", 20);

        Main.User result = main.findByEmail("lucy@test.com");

        Mockito.verify(userDao).addUser(new Main.User("lucy", "lucy@test.com", 20)); //SPY нужно, чтобы быть уверенным, что вызывался именно заданный метод
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSendEmail_OK () {
        Main.User user = new Main.User("lucy", "lucy@test.com", 20);
        doNothing().when(emailService).send(anyString()); //Если вызов void метода влияет на состояние, то doNothing() игнорирует изменения в тесте
    }

    @Test
    public void testSpy() {
        ArrayList<Object> users = Mockito.spy(new ArrayList<>());
//        users.add(new Main.User(null, null, null));
        users.add(new Main.User(null, null, null));
        Mockito.verify(users).add(new Main.User(null, null, null));
        Assert.assertEquals(1, users.size());
    }

    class MainWrapper extends Main {
        @Override
        User modifyUser(User user) { //Пробрасывает user через modifyUser. Так лучше не делать.
            return user;
        }
    }

}