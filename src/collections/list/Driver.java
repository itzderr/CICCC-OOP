package collections.list;

public class Driver {
    public static void main(String[] args) {
        MyLinkedList<String> ll = new MyLinkedList<>();
        ll.addFirst("Hello");
        ll.addFirst("Bye");
        ll.addFirst("Hola");

        System.out.println(ll);
    }
}
