import java.util.*;
class ReverseWord{
    public static String reverse(String s){
        String words[] = s.split("\\.");
        List<String> sb = new ArrayList<>();
        for(String p : words){
            if(!p.isEmpty()){
                sb.add(p);
            }
        }
        if(sb.isEmpty()){
            return "";
        }
        Collections.reverse(sb);
        return String.join(".", sb);
    }
    public static void main(String[] args) {
        String s = "i.like.this.program.very.much";
        System.out.println(reverse(s));
    }
}