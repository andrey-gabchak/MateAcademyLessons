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
    public void testSizeIncrease() {
        arrayList.add(7);
        int expectedResult = 6;
        Assert.assertEquals(expectedResult, arrayList.size());
    }

    @Test
    public void testSizeDecrease() {
        int indexForRemove = 4;
        arrayList.remove(indexForRemove);
        int expectedResult = 4;
        Assert.assertEquals(expectedResult, arrayList.size());
    }

    @Test
    public void testAdd() {
        arrayList.add(6);
        int expectedSize = 6;
        Integer expectedResult = 6;
        Assert.assertEquals(expectedSize, arrayList.size());
        Assert.assertEquals(expectedResult, arrayList.get(arrayList.size() - 1));
    }

    @Test
    public void testGet() {
        for (int i = 0; i < arrayList.size(); i++) {
            Assert.assertEquals(Integer.valueOf(i + 1), arrayList.get(i));
        }
    }

    @Test
    public void testRemove() {
        int expectedSize = 4;
        int indexForRemove = 0;
        arrayList.remove(indexForRemove);
        Integer expectedResult = 2;
        Assert.assertEquals(expectedResult, arrayList.get(indexForRemove));
        Assert.assertEquals(expectedSize, arrayList.size());
    }
}