import java.util.*;

class Postfix {
    public static int evaluate(String[] arr) {
        // code here
        Stack<Integer> S = new Stack<>();
        for(String token : arr){
            if(token.matches("-?\\d+")){
                S.push(Integer.parseInt(token));
            }else{
                int a = S.pop();
                int b = S.pop();
                switch(token){
                    case "+":
                        S.push(b + a);
                        break;
                    case "-":
                        S.push(b - a);
                        break;
                    case "*":
                        S.push(b * a);
                        break;
                    case "/":
                        S.push(b / a);
                        break;
                    }
                }
        }
        return S.pop();
    }
    public static void main(String[] args) {
        String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluate(arr)); 
    }
}