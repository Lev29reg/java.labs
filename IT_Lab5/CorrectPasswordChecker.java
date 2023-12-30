import java.util.regex.*;

public class CorrectPasswordChecker {
    public static void main(String[] args) {
        try {
            String password = "2h08443Q";
            Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.?[^!@#$%^&*]+$).{8,16}$");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches())
                System.out.println("Valid password");
            else
                System.out.println("Incorrect password");
        } catch (PatternSyntaxException e){
            System.out.println("Invalid pattern configure: " + e.getMessage());
        }
    }
}
