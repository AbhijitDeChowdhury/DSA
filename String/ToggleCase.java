class ToggleCase {
    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(ch); 
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "geeksForGeeks";
        String output = toggleCase(input);

        System.out.println("Original: " + input);
        System.out.println("Toggled : " + output);
    }
}
