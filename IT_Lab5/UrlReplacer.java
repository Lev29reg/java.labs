import java.util.regex.*;

public class UrlReplacer {
    public static void main(String[] args) {
        String link = "First example link: https://www.example.com and second example link: http://google.com";
        try {
            String regex = "\\b(https?|ftp|file)://[\\w-+&@#/%?=~|!:,.;]*[\\w-+&@#/%=~|]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(link);
            System.out.println(matcher.replaceAll("<a href=\"$0\"</a>"));
        } catch (PatternSyntaxException e) {
            System.out.println("Invalid pattern configure: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
