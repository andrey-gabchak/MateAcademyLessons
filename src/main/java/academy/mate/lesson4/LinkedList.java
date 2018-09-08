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

        System.out.println(numbers.getNode(5));
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
        return getNode(index).value;
    }

    private Node<T> getNode(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node;
        if (index > size / 2) {
            node = getFromTail(size - (index + 1));
        } else {
            node = getFromHead(index);
        }
        return node;
    }

    private Node<T> getFromTail(int index) {
        Node<T> node = tail;
        for (int i = 0; i < index; i++) {
            node = node.prev;
        }
        return node;
    }

    private Node<T> getFromHead(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
        Node<T> node = getNode(index);
        removeNode(node);
        size--;
    }

    private void removeNode(Node<T> node) {
        node.prev.next = node.next; //Node prevNode = node.prev.next;
        node.next.prev = node.prev;
    }

    public void remove(T t) {
        Node<T> node = getNodeByValue(t);
        removeNode(node);
        size--;
    }

    private Node<T> getNodeByValue(T value) {
        Node<T> node = head;
        Node<T> result = null;
        for (int i = 0; i < size; i++) {
            if (node.value == value) {
                result = node;
                break;
            }
            node = node.next;
        }
        return result;
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
        }
    }
}
