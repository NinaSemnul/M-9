//Написати свій клас MyHashMap як аналог класу HashMap.
//
//        Потрібно робити за допомогою однозв'язної Node.
//
//        Не може зберігати дві ноди з однаковими ключами.
//
//        Методи
//
//        put(E key, E value) додає пару ключ + значення
//        remove(E key) видаляє пару за ключем
//        clear() очищає колекцію
//        size() повертає розмір колекції
//        get(Object key) повертає значення (Object value) за ключем

import java.util.HashMap;



class MyHashMap <K,V> {
    private MyHashMap.Node prev;
    private MyHashMap.Node next;
    private int size;

    public MyHashMap() {
        prev = null;
        next = null;
        size = 0;
    }

    class Node {
        private K key;
        private V value;
        private MyHashMap.Node next;
        private MyHashMap.Node prev;

        public Node(K key , V value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    public void put(K key, V value){
        MyHashMap.Node newNode = new MyHashMap.Node(key,  value);
        if (prev == null) {
            prev = newNode;
        } else {
            next.next = newNode;
            newNode.prev = next;
        }
        next = newNode;
        size++;

    }


    public void remove(K key) {

        MyHashMap.Node now = prev;
        for (int i = 0; i < size; i++) {
            if (now.next.key == key) {
                now = now.next;
                break;
            }
        }
        if (now.prev == null) {
            prev = now.next;
        } else {
            now.prev.next = now.next;
        }
        if (now.next == null) {
            next = now.prev;
        } else {
            now.next.prev = now.prev;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {

        next = null;
        prev = null;
        size = 0 ;
    }

    public V get(K key){
        MyHashMap.Node now = prev;

        for (int i = 0; i < size; i++) {


            if (now.key == key){
                now = now.next;
            }
        }
        return (V) now.value;

    }

    public V getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyHashMap.Node now = prev;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        return (V) now.value;
    }

}

class MyHashMapTest {

    public static void main(String[] args) {

        testPut();
        testRemove();
        testClear();
        testSize();
        testGet();
    }

    public static void testPut() {
        System.out.println("testPut() :  ");
        MyHashMap<String, Integer> list = new MyHashMap<String, Integer>();
        outputArray(list);
        list.put("one", 1000);
        list.put("two", 2000);
        list.put("three" ,3000);
        list.size();
        System.out.println("after add  ");
        outputArray(list);

        System.out.println("_____________________________");
    }


    public static void testRemove() {
        MyHashMap<Integer,String> list = new MyHashMap<>();
        list.put(1, "Hello");
        list.put(2, "java");
        list.put(3, "student");
        System.out.println("testRemove() :  ");
        outputArray(list);
        System.out.println("list.size() after add: " + list.size());
        list.remove(2);
        System.out.println("list.size() after remove: " + list.size());
        outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testClear() {
        MyHashMap<Integer, String> list = new MyHashMap<>();
        list.put(1, "dog");
        list.put(2, "cat");
        list.put(3, "piton");
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
        MyHashMap<Integer,String> list = new MyHashMap<>();
        System.out.println("list.size() before add: " + list.size());
        list.put(1, "apple");
        System.out.println("list.size() after add: " + list.size());
        outputArray(list);
        list.put(2, "banana");
        System.out.println("list.size() after add: " + list.size());
        list.put(3, "cherry");
        System.out.println("list.size() after add: " + list.size());
        outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testGet() {
        System.out.println("testGet(key) : ");
        MyHashMap<Integer,String> list = new MyHashMap<>();
        list.put(1, "dog");
        list.put(2, "cat");
        list.put(3, "piton");

        outputArray(list);
        System.out.println("Get(1) : " + list.get(1));
        outputArray(list);
        System.out.println("_____________________________");

    }


    public static <E> void outputArray(MyHashMap o) {
        System.out.print("list: ");

        for (int i = 0; i < o.size(); i++) {
            if(i < o.size() - 1) {
                System.out.print(o.getIndex(i) + "; ");
            }else {
                System.out.print(o.getIndex(i));
            }
        }
        System.out.println();

    }

}
