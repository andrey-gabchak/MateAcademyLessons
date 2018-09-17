package academy.mate.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
    }

    @Test
    public void testSizeIncrease() {
        linkedList.add(5);
        int expectedResult = 5;
        Assert.assertEquals(expectedResult, linkedList.size());
    }

    @Test
    public void testSizeDecrease() {
        linkedList.remove(1);
        int expectedResult = 3;
        Assert.assertEquals(expectedResult, linkedList.size());
    }

    @Test
    public void add() {
        linkedList.add(6);
        int expectedResult = 6;
        int size = linkedList.size();
        Assert.assertEquals(expectedResult, size);
        Assert.assertEquals(expectedResult, linkedList.get(size).intValue());
    }

    @Test
    public void get() {
        Assert.assertEquals(Integer.valueOf(1), linkedList.get(0));
        Assert.assertEquals(Integer.valueOf(2), linkedList.get(1));
        Assert.assertEquals(Integer.valueOf(3), linkedList.get(2));
        Assert.assertEquals(Integer.valueOf(4), linkedList.get(3));
    }

    @Test
    public void testRemoveByIndexThatLastElemShifted() {
        Integer expectedResult = 2;
        linkedList.remove(0);
        Assert.assertEquals(expectedResult, linkedList.get(1));
    }

    @Test
    public void testRemoveByValue() {
        Integer expectedResult = 3;
        linkedList.remove(Integer.valueOf(2));
        Assert.assertEquals(expectedResult, linkedList.get(1));
    }
}