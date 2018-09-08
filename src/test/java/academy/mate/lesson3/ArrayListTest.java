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
        Assert.assertEquals(Integer.valueOf(1), arrayList.get(0));
        Assert.assertEquals(Integer.valueOf(2), arrayList.get(1));
        Assert.assertEquals(Integer.valueOf(3), arrayList.get(2));
        Assert.assertEquals(Integer.valueOf(4), arrayList.get(3));
        Assert.assertEquals(Integer.valueOf(5), arrayList.get(4));
    }

    @Test
    public void remove() {
    }
}