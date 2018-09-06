package academy.mate.lesson4;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        System.out.println(numbers.get(5));
    }

    public LinkedList() {

    }

    public int size() {
        return size;
    }

    public void add(T t) {
        Node<T> node = new Node<>(t);
        addNode(node);
        size++;
    }

    public T get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T t;
        if (index > size / 2) {
            t = getFromTail(size - (index + 1));
        } else {
            t = getFromHead(index);
        }
        return t;
    }

    private T getFromTail(int index) {
        Node<T> node = tail;
        for (int i = 0; i < index; i++) {
            node = node.prev;
        }
        return node.value;
    }

    private T getFromHead(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    private void addNode(Node<T> node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void remove(int index) {
        size--;
    }

    public void remove(T t) {
        size--;
    }

    class Node<T> {
        private T value;
        private Node prev;
        private Node next;
        private boolean isHeas;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
//            this.prev = prev;
//            this.next = next;
        }
    }
}
