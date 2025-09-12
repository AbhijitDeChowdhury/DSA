import java.util.*;

class Largest{
    public int second_largest(int arr[]){
        if(arr.length < 2) return -1;
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > largest){
                secondlargest = largest;
                largest = num;
            }
            else if(num < largest && num > secondlargest){
                secondlargest = num;
            }
        }
        return(secondlargest == Integer.MIN_VALUE)?-1 : secondlargest;
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

        System.out.print("Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Largest obj = new Largest();
        int result = obj.second_largest(arr);

        System.out.println("Second Largest Element: " + result);
    }
}