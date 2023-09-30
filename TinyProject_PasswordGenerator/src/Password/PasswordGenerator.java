//Name:SURAJ.V
//Enrollment Number:EBEON0723817760
//Project Title:Password Generator
package Password;
import java.security.SecureRandom;
import java.util.Scanner;


public class PasswordGenerator {

    public static void main(String[] args) {// Main Method 
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Generator");

        // Prompt the user for password length
        System.out.print("Enter password length: ");//Entering the length of the password
        int passwordLength = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Prompt the user for character types
        System.out.print("Include uppercase letters? (Y/N): ");//Whether the user want to include Uppercase or not  
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include lowercase letters? (Y/N): ");//Whether the user want to include Lowercase or not  
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include numbers? (Y/N): ");//Whether the user want to include numbers or not  
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("Y");

        System.out.print("Include special characters? (Y/N): ");//Whether the user want to include Special Characters or not  
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("Y");

        // Generate the password
        String password = generatePassword(passwordLength, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);

        // Display the generated password
        System.out.println("\nGenerated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars) {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

        StringBuilder validChars = new StringBuilder();
        if (includeUppercase) validChars.append(uppercaseChars);
        if (includeLowercase) validChars.append(lowercaseChars);
        if (includeNumbers) validChars.append(numberChars);
        if (includeSpecialChars) validChars.append(specialChars);

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}


