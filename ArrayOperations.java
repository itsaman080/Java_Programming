import java.util.Scanner;

public class ArrayOperations {

    public static int[] insertAtBeginning(int[] arr, int size, int element) {
        int[] newArr = new int[size + 1];
        newArr[0] = element;
        for (int i = 0; i < size; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    public static int[] insertAtEnd(int[] arr, int size, int element) {
        int[] newArr = new int[size + 1];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        newArr[size] = element;
        return newArr;
    }

    public static int[] insertAtPosition(int[] arr, int size, int element, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position.");
            return arr;
        }
        int[] newArr = new int[size + 1];
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        newArr[position] = element;
        for (int i = position; i < size; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    public static int[] deleteFromBeginning(int[] arr, int size) {
        if (size == 0) return arr;
        int[] newArr = new int[size - 1];
        for (int i = 1; i < size; i++) {
            newArr[i - 1] = arr[i];
        }
        return newArr;
    }

    public static int[] deleteFromEnd(int[] arr, int size) {
        if (size == 0) return arr;
        int[] newArr = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static int[] deleteAtPosition(int[] arr, int size, int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position.");
            return arr;
        }
        int[] newArr = new int[size - 1];
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }
        for (int i = position + 1; i < size; i++) {
            newArr[i - 1] = arr[i];
        }
        return newArr;
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        while (true) {
            System.out.println("\nArray Operations Menu:");
            System.out.println("1. Insert at the Beginning");
            System.out.println("2. Insert at the End");
            System.out.println("3. Insert at a Specific Position");
            System.out.println("4. Delete from the Beginning");
            System.out.println("5. Delete from the End");
            System.out.println("6. Delete from a Specific Position");
            System.out.println("7. Display Array");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            int element, position;

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    element = scanner.nextInt();
                    arr = insertAtBeginning(arr, size, element);
                    size++;
                    System.out.print("Array after insertion at the beginning: ");
                    printArray(arr, size);
                    break;

                case 2:
                    System.out.print("Enter the element to insert: ");
                    element = scanner.nextInt();
                    arr = insertAtEnd(arr, size, element);
                    size++;
                    System.out.print("Array after insertion at the end: ");
                    printArray(arr, size);
                    break;

                case 3:
                    System.out.print("Enter the element to insert: ");
                    element = scanner.nextInt();
                    System.out.print("Enter the position to insert (0-based index): ");
                    position = scanner.nextInt();
                    arr = insertAtPosition(arr, size, element, position);
                    size++;
                    System.out.print("Array after insertion at position " + position + ": ");
                    printArray(arr, size);
                    break;

                case 4:
                    arr = deleteFromBeginning(arr, size);
                    size--;
                    System.out.print("Array after deletion from the beginning: ");
                    printArray(arr, size);
                    break;

                case 5:
                    arr = deleteFromEnd(arr, size);
                    size--;
                    System.out.print("Array after deletion from the end: ");
                    printArray(arr, size);
                    break;

                case 6:
                    System.out.print("Enter the position to delete (0-based index): ");
                    position = scanner.nextInt();
                    arr = deleteAtPosition(arr, size, position);
                    size--;
                    System.out.print("Array after deletion from position " + position + ": ");
                    printArray(arr, size);
                    break;

                case 7:
                    System.out.print("Current Array: ");
                    printArray(arr, size);
                    break;

                case 0:
                    System.out.println("Exited...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
