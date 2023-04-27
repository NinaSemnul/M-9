//Написати свій клас MyStack як аналог класу Stack, який працює за принципом LIFO (last-in-first-out).
//
//        Можна робити за допомогою Node або використати масив.
//
//        Методи
//
//   +     push(E value) додає елемент в кінець
//   +     remove(int index) видаляє елемент за індексом
//   +     clear() очищає колекцію
//   +     size() повертає розмір колекції
//   +     peek() повертає перший елемент стеку
//   +     pop() повертає перший елемент стеку та видаляє його з колекції


import java.util.Stack;

class MyStack <E>{
    private MyStack.Node prev;
    private MyStack.Node next;
    private int size;


    public MyStack() {
        prev = null;
        next = null;
        size = 0;
    }

    class Node {

        private E value;
        private MyStack.Node next;
        private MyStack.Node prev;

        public Node(E value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyStack.Node now = prev;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        return (E) now.value;
    }

    public void push(E value){
        MyStack.Node newNode = new MyStack.Node(value);
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

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyStack.Node now = prev;
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

    public int size() {
        return size;
    }

    public void clear() {

        next = null;
        prev = null;
        size = 0 ;
    }

    public E peek() {

        return get(0);
    }

    public E pop(){
        E first = get(0);

        remove(0);

        return first  ;

    }

}



class MyStackTest {
    public static void main(String[] args) {

        testPush();
        testRemove();
        testClear();
        testSize();
        testPeek();
        testPop();


    }

    public static void testPush() {
        System.out.println("testPush() :  ");
        MyStack<Integer> list = new MyStack<Integer>();
        outputArray(list);
        list.push(1000);
        list.push(2000);
        list.push(3000);
        list.size();
        System.out.println("after add  ");
        outputArray(list);

        System.out.println("_____________________________");
    }


    public static void testRemove() {
        MyStack<String> list = new MyStack<>();
        list.push("Hello");
        list.push("java");
        list.push("student");
        System.out.println("testRemove() :  ");
        outputArray(list);
        System.out.println("list.size() after add: " + list.size());
        list.remove(1);
        System.out.println("list.size() after remove: " + list.size());
        outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testClear() {
        MyStack<String> list = new MyStack<>();
        list.push("dog");
        list.push("cat");
        list.push("piton");
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
        MyStack<String> list = new MyStack<>();
        System.out.println("list.size() before add: " + list.size());
        list.push("apple");
        System.out.println("list.size() after add: " + list.size());
        outputArray(list);
        list.push("banana");
        System.out.println("list.size() after add: " + list.size());
        list.push("cherry");
        System.out.println("list.size() after add: " + list.size());
        outputArray(list);
        System.out.println("_____________________________");
    }

    public static void testPeek() {
        System.out.println("testPeek() : ");
        MyStack<String> list = new MyStack<>();
        list.push("dog");
        list.push("cat");
        list.push("piton");

        outputArray(list);
        System.out.println("Peek() : " + list.peek());
        System.out.println("_____________________________");
    }

    public static void testPop() {
        System.out.println("testPop() : ");
        MyStack<String> list = new MyStack<>();
        list.push("dog");
        list.push("cat");
        list.push("piton");

        outputArray(list);
        System.out.println("Pool() : " + list.pop());
        outputArray(list);
        System.out.println("_____________________________");

    }


    public static <E> void outputArray(MyStack o) {
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
