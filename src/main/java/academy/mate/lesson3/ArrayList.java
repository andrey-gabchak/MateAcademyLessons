package academy.mate.lesson3;

public class ArrayList<T> {

    private static final int INITIAL_LENGTH = 16;
    private int size = 0;
    private int currentLength;
    private static final double LOAD_FACTOR = 1.25;

    private Object[] array;

    public ArrayList() {
        this.array = new Object[INITIAL_LENGTH];
        currentLength = INITIAL_LENGTH;
    }

    public void add(T t) {
        isCurrentLengthTooSmall();
        array[size] = t;
        size++;
    }

    public void set(int index, T t) {
        array[index] = t;
    }

    public void add(int index, T t) {
        isCurrentLengthTooSmall();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = t;
        size++;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size);
        size--;
        if (size * LOAD_FACTOR <= currentLength) {
            decreaseLengthArray();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void isCurrentLengthTooSmall() {
        if (size * LOAD_FACTOR >= currentLength) {
            increaseLengthArray();
        }
    }

    private void increaseLengthArray() {
        currentLength *= LOAD_FACTOR;
        Object[] result = new Object[currentLength];
        System.arraycopy(array, 0, result, 0, size);
        array = result;
    }

    private void decreaseLengthArray() {
        currentLength /= LOAD_FACTOR;
        Object[] result = new Object[currentLength];
        System.arraycopy(array, 0, result, 0, size);
        array = result;
    }


    /*
    TODO method: clone()
    TODO method: contains(Object o)
    TODO method: indexOf(Object o)
    */
}
