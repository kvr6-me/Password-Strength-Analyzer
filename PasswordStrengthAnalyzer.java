import java.util.Scanner;

    public class PasswordStrengthAnalyzer {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a password to check: ");
            String password = scanner.nextLine();

            System.out.println("Strength: " + getStrength(password));
        }

        public static String getStrength(String password) {
            // 1. Basic Length Check
            if (password.length() < 8) {
                return "Very Weak (Too Short)";
            }

            // 2. Variables to track what we find
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            // 3. Loop through every character in the password
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                else if (Character.isLowerCase(c)) hasLower = true;
                else if (Character.isDigit(c)) hasDigit = true;
                else hasSpecial = true; // If it's not a letter or number, it's special
            }

            // 4. Calculate Score (Max score is 4)
            int score = 0;
            if (hasUpper) score++;
            if (hasLower) score++;
            if (hasDigit) score++;
            if (hasSpecial) score++;

            // 5. Return Result based on score
            if (score < 2) return "Weak password mate";
            else if (score < 4) return "'Mid'";
            else return "Tough fella!";
        }
    }

