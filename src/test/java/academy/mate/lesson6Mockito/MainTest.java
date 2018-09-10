package academy.mate.lesson6Mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Mock
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
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSendEmail_OK () {
        Main.User user = new Main.User("lucy", "lucy@test.com", 20);
        doNothing().when(emailService).send(anyString()); //Если вызов void метода влияет на состояние, то doNothing() игнорирует изменения в тесте


    }

    class MainWrapper extends Main {
        @Override
        User modifyUser(User user) { //Пробрасывает user через modifyUser. Так лучше не делать.
            return user;
        }
    }

}