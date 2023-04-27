//Написати свій клас MyQueue як аналог класу Queue, який буде працювати за принципом FIFO (first-in-first-out).
//
//        Можна робити за допомогою Node або використати масив.
//
//        Методи
//
//        add(E value) додає елемент в кінець
//        clear() очищає колекцію
//        size() повертає розмір колекції
//        peek() повертає перший елемент з черги
//        poll() повертає перший елемент з черги і видаляє його з колекції
import java.util.Queue;
class MyQueue <E> {
    private static final int longArray = 10;
    private E[] data;
    private int size;

    public MyQueue() {
        this(longArray);
    }

    public MyQueue(int longArray) {
        data = (E[]) new Object[longArray];
    }


    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void add(E value) {
        changeLongArray();
        data[size++] = value;
    }

    public int size() {
        return size;
    }

    public void clear() {

        data = null;
        size = 0;
    }

    public E peek() {
        checkIndex(0);
        return data[0];
    }

    public E pool() {
        checkIndex(0);
        E firstEl = data[0];
        size--;
        changeLongArrayMin();
        return firstEl;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);

        }
    }

    private void changeLongArray() {
        if (size == data.length) {
            E[] newData = (E[]) new Object[2 * data.length];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }

    }

    private void changeLongArrayMin() {

        E[] newData = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i + 1];

        }
        data = newData;
    }
}

 class MyQueueTest {
    public static void main(String[] args) {

        testAdd();
        testClearAndSize();
        testPeek();
        testPoll();

    }



    public static void testAdd() {
        System.out.println("testAdd() :  ");
        MyQueue<Integer> list = new MyQueue<>();
        outputArray(list);
        list.add(1000);
        list.add(2000);
        list.add(3000);
        list.size();

        System.out.println("list.get(0): " + list.get(0));
        System.out.println("list.get(1): " + list.get(1));
        System.out.println("list.get(2): " + list.get(2));
        outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testClearAndSize() {
        MyQueue<String> list = new MyQueue<>();
        list.add("dog");
        list.add("cat");
        list.add("piton");
        System.out.println("testClear() : ");
        System.out.println("list.size() after add: " + list.size());
        outputArray(list);
        list.clear();
        System.out.println("list.size() after clear: " + list.size());
        outputArray(list);
        System.out.println("_____________________________");

    }

    public static void testPeek() {
        System.out.println("testPeek() : ");
        MyQueue<String> list = new MyQueue<>();
        list.add("dog");
        list.add("cat");
        list.add("piton");

        outputArray(list);
        System.out.println("Peek() : " + list.peek());
        System.out.println("_____________________________");
    }

    public static void testPoll() {
        System.out.println("testPoll() : ");
        MyQueue<String> list = new MyQueue<>();
        list.add("dog");
        list.add("cat");
        list.add("piton");

        outputArray(list);
        System.out.println("Pool() : " + list.pool());
        outputArray(list);
        System.out.println("_____________________________");

    }

    public static <E> void outputArray(MyQueue o) {
        System.out.print("list: ");

        for (int i = 0; i < o.size(); i++) {
            if (i <= o.size() - 1) {
                System.out.print(o.get(i) + "; ");
            } else {
                System.out.print(o.get(i));
            }
        }
        System.out.println();
    }

}



