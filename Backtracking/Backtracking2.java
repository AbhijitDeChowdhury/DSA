import java.util.*;
class Solution {
    public  double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(x == 0) return 0.0;
        if(x == 1) return 1.0;
        if(x == -1 && n % 2 == 0) return 1.0;
        if(x == -1 && n % 2 != 0) return -1.0;
        long Bf = n;
        if(n < 0){
            x = 1 / x;
            Bf = -Bf;
        }
        double ans = 1.0;
        while(Bf > 0){
            if(Bf % 2 == 1){
                ans *= x;
            }
            x *= x;
            Bf /= 2;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of x: ");
        double x = sc.nextInt();
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        double result = sol.myPow(x, n);
        System.out.println("The value of " + x + " raised to the power " + n + " is: " + result);
    }
}