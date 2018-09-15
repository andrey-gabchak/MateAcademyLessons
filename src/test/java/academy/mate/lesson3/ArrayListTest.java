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
    public void testAddToTheEndOfArrayList() {
        arrayList.add(6);
        int expectedSize = 6;
        Integer expectedResult = 6;
        Assert.assertEquals(expectedSize, arrayList.size());
        Assert.assertEquals(expectedResult, arrayList.get(arrayList.size() - 1));
    }

    @Test
    public void testAddByIndex() {
        int index = 1;
        Integer value = 10;
        arrayList.add(index, value);
        Assert.assertEquals(value, arrayList.get(index));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexNegativeScenario() {
        int indexDoesntExist = 20;
        Integer value = 14;
        arrayList.add(indexDoesntExist, value);
    }

    @Test
    public void testGet() {
        for (int i = 0; i < arrayList.size(); i++) {
            Assert.assertEquals(Integer.valueOf(i + 1), arrayList.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegativeScenario() {
        int indexDoesntExist = 20;
        arrayList.get(indexDoesntExist);
    }

    @Test
    public void testSet() {
        int indexForSet = 3;
        Integer valueForSet = 10;
        arrayList.set(indexForSet, valueForSet);
        Assert.assertEquals(valueForSet, arrayList.get(indexForSet));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetNegativeScenario() {
        int indexDoesntExist = 20;
        Integer value = 15;
        arrayList.set(indexDoesntExist, value);
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

    @Test
    public void testRemoveFirstElem() {
        Integer expectedResult = 2;
        arrayList.remove(0);
        Assert.assertEquals(expectedResult, arrayList.get(0));
    }

    @Test
    public void testRemoveLastElem() {
        Integer expectedResult = 4;
        arrayList.remove(arrayList.size() - 1);
        Assert.assertEquals(expectedResult, arrayList.get(arrayList.size() - 1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveNegativeScenario() {
        int indexDoesntExist = 20;
        arrayList.remove(indexDoesntExist);
    }

    @Test
    public void testIsNotEmpty() {
        boolean expectedResult = false;
        Assert.assertEquals(expectedResult, arrayList.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        int sizeOfArrayListBeforePurge = arrayList.size();
        for (int i = 0; i < sizeOfArrayListBeforePurge; i++) {
            arrayList.remove(0);
        }
        Assert.assertTrue(arrayList.isEmpty());
    }
}