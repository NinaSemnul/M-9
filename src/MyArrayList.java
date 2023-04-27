//Напишіть свій клас MyArrayList як аналог класу ArrayList.
//
//        Можна використовувати 1 масив для зберігання даних.
//
//        Методи
//
//        add(Object value) додає елемент в кінець
//        remove(int index) видаляє елемент із вказаним індексом
//        clear() очищає колекцію
//        size() повертає розмір колекції
//        get(int index) повертає елемент за індексом


import java.util.Arrays;

class MyArrayList<E> {
    private static final int longArray = 10;
    private E[] data;
    private int size;

    public MyArrayList() {
        this(longArray);
    }

        public MyArrayList(int o) {
        data = (E[]) new Object [o];
    }
    public void add(E value) {
        changeLongArray();
        data[size++] = value;
    }
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];

        for (int i = index; i <= size ; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return removedValue;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
    public int size() {
        return size;
    }
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void changeLongArray() {
        if (size == data.length) {
            E[] newData = (E[]) new Object[2 * data.length];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }


    private void checkIndex(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Invalid index: " + index);

    }
}

}


class MyArrayListTest {

    public static void main(String[] args) {

        testAddAndGet();  //1 , 5
        testRemove();  //2
        testClear();  //3
        testSize();  //4

    }


    public static void testAddAndGet() {
        System.out.println("testAddAndGet() :  ");
        MyArrayList<Integer> list = new MyArrayList<>();
        outputArray(list);
        list.add(1000);
        list.add(2000);
        list.add(3000);
        list.size();

        System.out.println("list.get(0): " + list.get(0) );
        System.out.println("list.get(1): " + list.get(1) );
        System.out.println("list.get(2): " + list.get(2));
        outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("java");
        list.add("student");
        System.out.println("testRemove() :  ");
        outputArray(list);
        System.out.println("list.size() after add: " + list.size());
        list.remove(1);
        System.out.println("list.size() after remove: " + list.size());
        System.out.println("list.get(0): " + list.get(0));
        System.out.println("list.get(1): " + list.get(1));
        outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testClear() {
        MyArrayList<String> list = new MyArrayList<>();
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

    public static void testSize() {
        System.out.println("testSize()");
        MyArrayList<String> list = new MyArrayList<>();
        System.out.println("list.size() before add: " + list.size());
        list.add("apple");
        System.out.println("list.size() after add: " + list.size());
        outputArray(list);
        list.add("banana");
        System.out.println("list.size() after add: " + list.size());
        list.add("cherry");
        System.out.println("list.size() after add: " + list.size());
        outputArray(list);
        System.out.println("_____________________________");
    }


    public static <E> void outputArray(MyArrayList o) {
        System.out.print("list: ");

        for (int i = 0; i < o.size(); i++) {
            if(i < o.size() - 1) {
                System.out.print(o.get(i) + "; ");
            }else {
                System.out.print(o.get(i));
            }
        }
        System.out.println();

    }



}
