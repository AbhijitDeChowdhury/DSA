import java.util.*;
class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        char[] word_arr = word.toCharArray();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == word_arr[0] && Exits(mat, i,j,word_arr,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean Exits(char[][] mat, int i, int j, char[] word, int idx){
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length|| mat[i][j] != word[idx]){ 
            return false;
        }
        if(idx == word.length - 1){
            return true;
        }

        char ch = mat[i][j];
        mat[i][j] = '*';

        boolean res =
                Exits(mat, i + 1, j, word, idx + 1)||
                Exits(mat, i - 1, j, word, idx + 1)||
                Exits(mat, i, j + 1, word, idx + 1)||
                Exits(mat, i, j - 1, word, idx + 1);
        
        mat[i][j] = ch;        
        return res;
    }
     public static void main(String[] args) {
        char[][] mat = {
            {'T', 'E', 'E'},
            {'E', 'G', 'K'},
            {'A', 'B', 'F'}
        };

        String word1 = "GEEK";  // should return true
        String word2 = "TEA";     // should return true
        String word3 = "ABC";    // should return false

        System.out.println("Word " + word1 + " exists: " + Solution.isWordExist(mat, word1));
        System.out.println("Word " + word2 + " exists: " + Solution.isWordExist(mat, word2));
        System.out.println("Word " + word3 + " exists: " + Solution.isWordExist(mat, word3));
    }
}