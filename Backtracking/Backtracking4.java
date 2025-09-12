import java.util.*;

class Solution {
    public static boolean isSafe(int[][] mat, int row, int col, int number){
        // check column
        for(int i = 0; i < mat.length; i++){
            if(mat[i][col] == number){
                return false;
            }
        }

        // check row
        for(int j = 0; j < mat.length; j++){
            if(mat[row][j] == number){
                return false;
            }
        }

        // check 3x3 subgrid
        int sr = 3 * (row/3);
        int sc = 3 * (col/3);

        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(mat[i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean helper(int[][] mat, int row, int col){
        if(row == mat.length){
            return true;
        }

        int nrow, ncol;
        if(col == mat.length - 1){
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if(mat[row][col] != 0){
            return helper(mat, nrow, ncol);
        } else {
            for(int i = 1; i <= 9; i++){
                if(isSafe(mat, row, col, i)){
                    mat[row][col] = i;
                    if(helper(mat, nrow, ncol)){
                        return true;
                    } else {
                        mat[row][col] = 0;
                    }
                }
            }
        }
        return false;
    }

    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        helper(mat, 0, 0);
    }

    public static void main(String[] args){
        int[][] mat = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };

        System.out.println("Original Sudoku: ");
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        solveSudoku(mat);

        System.out.println("\nSolved Sudoku: ");
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
