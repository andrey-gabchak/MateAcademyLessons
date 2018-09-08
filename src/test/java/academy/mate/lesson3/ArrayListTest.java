package academy.mate.lesson3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    private ArrayList<Integer> arrayList;

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
    }

    @Test
    public void add() {
        arrayList.add(6);
        int expectedSize = 6;
        Integer expectedResult = 6;
        Assert.assertEquals(expectedSize, arrayList.size());
        Assert.assertEquals(expectedResult, arrayList.get(arrayList.size() - 1));
    }

    @Test
    public void get() {
    }

    @Test
    public void remove() {
    }
}