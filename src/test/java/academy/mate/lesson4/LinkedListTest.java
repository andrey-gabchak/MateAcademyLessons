package academy.mate.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedList<>();
    }

    @Test
    public void size() {
    }

    @Test
    public void add() {
    }

    @Test
    public void get() {
    }

    @Test
    public void testRemoveByIndexThatLastElemShifted() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Integer expectedResult = 3;
        linkedList.remove(1);
        Assert.assertEquals(expectedResult, linkedList.get(1));
    }

    @Test
    public void testRemoveByValue() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(2);
        Integer expectedResult = 3;
        linkedList.remove(Integer.valueOf(2));
        Assert.assertEquals(expectedResult, linkedList.get(1));
    }
}