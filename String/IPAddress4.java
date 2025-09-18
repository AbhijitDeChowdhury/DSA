import java.util.*;

class IPAddress4 {

    public boolean isValid(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        String[] parts = s.split("\\.", -1);
        if(parts.length != 4){
            return false;
        }
        for(String p : parts){
            if(p.length() == 0){
                return false;
            }
            if(p.length() > 3){
                return false;
            }
            if(p.length() > 1 && p.charAt(0) == '0'){
                return false;
            }
            for(int i = 0; i < p.length(); i++){
                char c = p.charAt(i);
                if(c < '0' || c > '9'){
                    return false;
                }
            }
            int val = Integer.parseInt(p);
            if(val < 0 || val > 255){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String s = sc.nextLine();

        IPAddress obj = new IPAddress();
        boolean IP = obj.isValid(s);
        if(IP){
            System.out.println("Correct IP Address (IPV4)");
        }else{
            System.out.println("Incorrect IP Address (IPV4)");
        }
    }
}