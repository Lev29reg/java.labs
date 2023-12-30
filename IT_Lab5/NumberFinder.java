import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            String text = "The price of -10 the 11 product is $19.99";
            Pattern pattern = Pattern.compile("[-]+\\d+|\\d+\\.\\d+|\\d+");
            //String regex = "(";
            //Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            //matcher.group();
            while (matcher.find())
                System.out.println(matcher.group());
        } catch (PatternSyntaxException e){
            System.out.println("Invalid pattern configure: " + e.getMessage());
        } catch (IllegalStateException e){
            System.out.println("Invalid matcher using: " + e.getMessage());
        }
    }
}