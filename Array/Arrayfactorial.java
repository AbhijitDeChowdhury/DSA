import java.util.*;

class ArrayFact {
    public static ArrayList<Integer> fact(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
	int fact = 1;
        for (int n : arr) {
		if (n == 0) {
			ans.add(1);
		}
        	else{
            	fact *= n;
		ans.add(fact);
		}
	  }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println("Original Array: " + arr);
        System.out.println("Factorial of Array: " + fact(arr));
    }
}
