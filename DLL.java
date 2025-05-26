import java.util.Scanner;

class Node {
    int data;
    Node next, prev;

    Node() {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the data");
        data = ob.nextInt();
        next = null;
        prev = null; 
    }
}

public class DLL {
    Node head;
    int count;

    Main() {
        head = null;
        count = 0;
    }

    void insertBegin() {
        Node newnode = new Node();
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode; 
            head = newnode;
        }
        count++;
    }

    void insertEnd() {
        Node newnode = new Node();
        if (head == null) {
            head = newnode;
        } else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newnode;
            newnode.prev = ptr; 
        }
        count++;
    }

    void display() {
        if (head == null)
            System.out.println("List empty");
        else {
            System.out.println("List elements = ");
            Node ptr = head;
            while (ptr != null) {
                System.out.print(ptr.data + "\t");
                ptr = ptr.next;
            }
            System.out.println("");
        }
    }

    void deleteBegin() {
        if (head == null)
            System.out.println("List is empty, cannot delete");
        else {
            System.out.println("Deleting = " + head.data);
            head = head.next;
            if (head != null)
                head.prev = null; 
            count--;
        }
    }

    void deleteEnd() {
        if (head == null)
            System.out.println("List is empty, cannot delete");
        else {
            Node pp = head;
            Node cp = head;
            while (cp.next != null) {
                pp = cp;
                cp = cp.next;
            }
            System.out.println("Deleting = " + cp.data);
            if (count == 1) {
                head = null; 
            } else {
                pp.next = null; 
            }
            count--;
        }
    }

    void insertPos() {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the position");
        int pos = ob.nextInt();
        if (pos < 1 || pos > count + 1)
            System.out.println("Invalid position");
        else if (pos == 1)
            insertBegin();
        else if (pos == count + 1)
            insertEnd();
        else {
            Node newnode = new Node();
            Node pp = head;
            Node cp = head;
            for (int i = 1; i < pos; i++) {
                pp = cp;
                cp = cp.next;
            }
            pp.next = newnode;
            newnode.prev = pp;
            newnode.next = cp;
            cp.prev = newnode;
            count++;
        }
    }

    void deletePos() {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the position");
        int pos = ob.nextInt();
        if (pos < 1 || pos > count)
            System.out.println("Invalid position");
        else if (pos == 1)
            deleteBegin();
        else if (pos == count)
            deleteEnd();
        else {
            Node pp = head;
            Node cp = head
            for (int i = 1; i < pos; i++) {
                pp = cp;
                cp = cp.next;
            }
            System.out.println("Deleting = " + cp.data);
            pp.next = cp.next;
            cp.next.prev = pp;
            count--;
        }
    }

    public static void message() {
        System.out.println("1 Insert at the beginning");
        System.out.println("2 Insert at the end");
        System.out.println("3 Insert at the position");
        System.out.println("4 Delete at the beginning");
        System.out.println("5 Delete at the end");
        System.out.println("6 Delete at the position");
        System.out.println("7 Display");
        System.out.println("8 Exit");
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        int ch;
        Scanner ob = new Scanner(System.in);
        while (true) {
            message();
            System.out.println("Enter choice = ");
            ch = ob.nextInt();
            if (ch == 8)
                break;
            switch (ch) {
                case 1:
                    dll.insertBegin();
                    break;
                case 2:
                    dll.insertEnd();
                    break;
                case 3:
                    dll.insertPos();
                    break;
                case 4:
                    dll.deleteBegin();
                    break;
                case 5:
                    dll.deleteEnd();
                    break;
                case 6:
                    dll.deletePos();
                    break;
                case 7:
                    dll.display();
                    break;
                default:
                    break;
            }
        }
    }
}
