class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else  {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node findMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void printMiddle() {
        Node middle = findMiddle();
        if (middle == null) {
            System.out.println("middle: (null)");
        } else {
            System.out.println("middle: " + middle.data);
        }
    }
}

public class W05_LinkedList {
    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.add(3);
        numbers.add(4);

        numbers.printMiddle();
        numbers.display();

        numbers.add(6);
        numbers.add(8);

        numbers.printMiddle();
        numbers.display();

        numbers.delete(6);

        numbers.printMiddle();
        numbers.display();
    }
}
