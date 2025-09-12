import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> res; // To store all solutions
    
    // Function to check if a queen can be placed at (row, col)
    private static boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // Backtracking function to solve N-Queen
    private static void solve(int row, int n, int[] board) {
        if (row == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(board[i] + 1); // 1-based indexing
            }
            res.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board)) {
                board[row] = col;
                solve(row + 1, n, board);
            }
        }
    }

    // Main function to return all N-Queen solutions
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        res = new ArrayList<>();
        int[] board = new int[n];
        solve(0, n, board);
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of Queens: ");
        int n = sc.nextInt();
        Solution sol = new Solution();

        ArrayList<ArrayList<Integer>> ans = sol.nQueen(n);

        for (ArrayList<Integer> row : ans) {
            System.out.print("[");
            for (int i = 0; i < row.size(); i++) {
                System.out.print(row.get(i));
                if (i != row.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }
        sc.close();
    }
}
