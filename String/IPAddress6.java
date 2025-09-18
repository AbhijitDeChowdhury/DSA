import java.util.*;

class IPAddress6 {

    public boolean isValidIPv6(String s) {
        if(s == null || s.length() == 0) return false;

        if(s.indexOf("::") != s.lastIndexOf("::")) return false;

        String[] parts = s.split(":", -1);
        boolean hasDoubleColon = s.contains("::");

        if(!hasDoubleColon && parts.length != 8) return false;

        if(hasDoubleColon && (parts.length < 2 || parts.length > 8)) return false;

        for(String p : parts){
            if(p.length() == 0) continue;
            if(p.length() > 4) return false;
            for(char c : p.toCharArray()){
                if(!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String s = sc.nextLine();

        IPAddress obj = new IPAddress();
        boolean IP = obj.isValidIPv6(s);
        if(IP){
            System.out.println("Correct IP Address (IPv6)");
        }else{
            System.out.println("Incorrect IP Address (IPv6)");
        }
    }
}
