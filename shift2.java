import java.util.Scanner;

class shift2 {
    public static void main(String[] args) {
        int[] arr = {8, 16, 32, 64, 128};

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter  number of left shifts: ");
        int shifts = scanner.nextInt();

        System.out.println("Array before left shift:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        shifts = shifts % arr.length; 

        for (int i = 0; i < shifts; i++) {
            int first = arr[0];

            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = first;
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();

    }
}
