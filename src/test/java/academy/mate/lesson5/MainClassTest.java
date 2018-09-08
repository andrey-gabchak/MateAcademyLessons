package academy.mate.lesson5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MainClassTest {

    private MainClass mainClass;

    @Before
    public void init() throws Exception {
        mainClass = new MainClass(); //Нужно, если main class содержит состояние
    }

    @Test
    public void testSumPositiveScenario() {
        int expectedResult = 10;
        int actualResult = mainClass.sum(5, 5);
        Assert.assertEquals(expectedResult, actualResult);
    }



}