import java.util.*;

class Rotate {
    public static void rotate_array(int arr[], int d) {
        int n = arr.length;
        d = d % n;
        int[] temp = new int[n];
        int k = 0;

        for(int i = d; i < n; i++){
            temp[k++] = arr[i];
        }
        for(int i = 0; i < d; i++){
            temp[k++] = arr[i];
        }
        for(int i = 0; i < n; i++){
            arr[i] = temp[i];
        }
        for(int i = 0; i < n; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Original Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("Enter the number of positions to rotate: ");
        int d = sc.nextInt();
        rotate_array(arr, d);
    }
}