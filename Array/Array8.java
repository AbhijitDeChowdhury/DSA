import java.util.*;

class Solution {
    public static int max_profit (int prices[]) {
         if (prices == null || prices.length == 0) {
            return 0;
        }
       int maxProfit = 0;
       int minPrice = prices[0];

       for(int i = 1; i < prices.length; i++){
        if(prices[i] < minPrice){
            minPrice = prices[i];
        }
        else{
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
       }
       return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println("Maximum Profit: " + max_profit(prices));
    }
}