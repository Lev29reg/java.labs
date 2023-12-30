import java.io.*;
import java.util.Scanner;

public class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException(){}
    public static void email(String email) throws CustomEmailFormatException {
        char[] mass = email.toCharArray();
        if (email.contains("@") && (email.contains(".ru") || email.contains(".com")) &&
                mass[0] != '@' && !email.contains("@.")){
            System.out.println("Good");
        }else {
            throw new CustomEmailFormatException();
        }
    }

    public static void main(String[] args){
        try {
            System.out.print("Enter e-mail address: ");
            Scanner scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            email(email);
        } catch (CustomEmailFormatException e){
            try {
                String error = "Incorrect e-mail address";
                FileWriter writer = new FileWriter("errors.txt", true);
                writer.write(error + '\n');
                writer.close();
                System.out.println("Incorrect e-mail address");
            } catch (IOException exception){
                System.out.println("IOException " + exception.getMessage());
            }
        }
    }
}
