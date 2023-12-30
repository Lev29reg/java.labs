import java.util.regex.*;

public class IPChecker {
    public static void main(String[] args) {
        String ip = "100.125.133.255.";
        try {
            String regex = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ip);
            System.out.println(matcher.matches());
        } catch (PatternSyntaxException e) {
            System.out.println("Error with pattern syntax" + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
