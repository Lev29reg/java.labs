public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String s){
        char[] array = s.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--)
            reverse += array[i];
        return reverse;
    }

    public static boolean isPalindrome(String s){
        boolean palindrome = s.equals(reverseString(s));
        return palindrome;
    }
}
