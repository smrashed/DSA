public class MyLinkedList {

    private static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    public void remove(int data) {
        if (head == null) {
            return;
        }
        Node current = head;

        if (current.data == data) {
            head = current.next;
            return;
        }

        while (current.next != null) {
            
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.printList();

        myLinkedList.remove(40);
        myLinkedList.printList();

        myLinkedList.remove(30);
        myLinkedList.printList();

        myLinkedList.remove(10);
        myLinkedList.printList();

    }

}