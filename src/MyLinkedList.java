import org.w3c.dom.Node;

import   java.util.*;

import java.util.LinkedList;

//  Напишіть свій клас MyLinkedList як аналог класу LinkedList.
//
//        Не можна використовувати масив. Кожний елемент повинен бути окремим об'єктом-посередником (Node - нода), що зберігає посилання на попередній та наступний елемент колекції (двозв'язний список).
//
//        Методи
//
//     +   add(Object value) додає елемент в кінець
//        remove(int index) видаляє елемент із вказаним індексом
//        clear() очищає колекцію
//        size() повертає розмір колекції
//        get(int index) повертає елемент за індексом

public class MyLinkedList<E> {

    private Node prev;
    private Node next;
    private int size;


    public MyLinkedList() {
        prev = null;
        next = null;
        size = 0;
    }

    private class Node {
        private E value;
        private Node next;
        private Node prev;

        public Node(E value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    public void add(E value) {
        Node newNode = new Node(value);
        if (prev == null) {
            prev = newNode;
            next = newNode;
        } else {
            next.next = newNode;
            newNode.prev = next;
            next = newNode;
        }
        size++;

    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node now = prev;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        return (E) now.value;
    }



    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node  now = prev;
        for (int i = 0; i < index; i++) {
            now = now.next;
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

    public void clear() {

        next = null;
        prev = null;
        size = 0 ;
    }

    public int size() {
        return size;
    }




}


class MyLinkedListTest{

    public static void main(String[] args) {

        testAddAndGet();  //1
        testRemove();  //2
        testClear();  //3
        testSize();  //4


    }

    public static void testAddAndGet() {
        System.out.println("testAddAndGet() :  ");
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        outputArray(list);
        list.add(1000);
        list.add(2000);
        list.add(3000);
        list.size();
        System.out.println("after add  ");
        outputArray(list);

        System.out.println("list.get(0): " + list.get(0) );
        System.out.println("list.get(1): " + list.get(1) );
        System.out.println("list.get(2): " + list.get(2));
       // outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testRemove() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Hello");
        list.add("java");
        list.add("student");
        System.out.println("testRemove() :  ");
        outputArray(list);
        System.out.println("list.size() after add: " + list.size());
        list.remove(1);
        System.out.println("list.size() after remove: " + list.size());
        outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testClear() {
        MyLinkedList<String> list = new MyLinkedList<>();
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
        MyLinkedList<String> list = new MyLinkedList<>();
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

    public static <E> void outputArray(MyLinkedList o) {
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




