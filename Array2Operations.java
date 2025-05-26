import java.util.Scanner;

class Myarray {
    int[] a;
    int max, p;

    Myarray() {
        p = -1;
        max = 10;
        a = new int[max];
    }

    void insertBegin() {
        if (p == max - 1) {
            System.out.println("Array is full. Cannot insert.");
        } else {
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter the element to insert at the beginning: ");
            int ele = obj.nextInt();

            for (int i = p; i >= 0; i--) {
                a[i + 1] = a[i];
            }

            a[0] = ele;
            p++;
        }
    }

    void insertEnd() {
        if (p == max - 1) {
            System.out.println("Array is full. Cannot insert.");
        } else {
            Scanner ob = new Scanner(System.in);
            System.out.print("Enter the element to insert at the end: ");
            int ele = ob.nextInt();
            a[p + 1] = ele;
            p++;
        }
    }

    void insertAtPosition() {
        if (p == max - 1) {
            System.out.println("Array is full. Cannot insert.");
        } else {
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter the position to insert ");
            int pos = obj.nextInt();

            if (pos == 0) {
                insertBegin();
            } else if (pos == p + 1) {
                insertEnd();
            } else if (pos < 0 || pos > p + 1) {
                System.out.println("Invalid position.");
            } else {
                System.out.print("Enter the element to insert: ");
                int ele = obj.nextInt();
                for (int i = p; i >= pos; i--) {
                    a[i + 1] = a[i];
                }
                a[pos] = ele;
                p++;
            }
        }
    }

    void deleteAtPosition() {
        if (p == -1) {
            System.out.println("Array is empty. Cannot delete.");
        } else {
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter the position to delete: ");
            int pos = obj.nextInt();

            if (pos == 0) {
                deleteBegin();
            } else if (pos == p) {
                deleteEnd();
            } else if (pos < 0 || pos > p) {
                System.out.println("Invalid position.");
            } else {
                for (int i = pos; i < p; i++) {
                    a[i] = a[i + 1];
                }
                p--;
            }
        }
    }
    void deleteBegin() {
        if (p == -1) {
            System.out.println("Array is empty. Cannot delete.");
        } else {
            for (int i = 0; i < p; i++) {
                a[i] = a[i + 1];
            }
            p--;
        }
    }

    void deleteEnd() {
        if (p == -1) {
            System.out.println("Array is empty. Cannot delete.");
        } else {
            p--;
        }
    }

    void display() {
        if (p == -1) {
            System.out.println("Array is empty.");
        } else {
            System.out.println("Elements of the array:");
            for (int i = 0; i <= p; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    void messages() {
        System.out.println("1. Insert at the beginning");
        System.out.println("2. Insert at the end");
        System.out.println("3. Insert at a specific position");
        System.out.println("4. Delete from the beginning");
        System.out.println("5. Delete from the end");
        System.out.println("6. Delete from a specific position");
        System.out.println("7. Display the array");
        System.out.println("8. Exit");
    }
}

public class Array2Operations {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        Myarray arr = new Myarray();

        while (true) {
            arr.messages();
            System.out.print("Enter your choice: ");
            int ch = ob.nextInt();

            if (ch == 8) {
                break;
            } else {
                switch (ch) {
                    case 1:
                        arr.insertBegin();
                        break;
                    case 2:
                        arr.insertEnd();
                        break;
                    case 3:
                        arr.insertAtPosition();
                        break;
                    case 4:
                        arr.deleteBegin();
                        break;
                    case 5:
                        arr.deleteEnd();
                        break;
                    case 6:
                        arr.deleteAtPosition();
                        break;
                    case 7:
                        arr.display();
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            }
        }

        ob.close();
        System.out.println("Exited");
    }
}
