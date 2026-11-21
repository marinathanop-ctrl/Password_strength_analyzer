import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordAnalyzer
{
    private static final int Min_length = 8;
    private static final int bonus_length = 12;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the password that you want me to analyse and give you feedback for: ");
        
        String password = scan.nextLine();
        int score = calculateScore(password);
        String strength = classifyStrength(score);

        List<String> feedback = feedbackGeneration(password);
        
        System.out.println("\n~~~~~~~RESULTS~~~~~~~");
        System.out.println("Password score: " + score);
        System.out.println("Password strength: " + strength);
        
        System.out.println("\n~~~~~~~FEEDBACK~~~~~~~");

        for(String msg : feedback)
        {
            System.out.println("~" + msg);
        }

        scan.close();        
    }

    public static int calculateScore(String password)
    {
        int score = 0;
        //length related point system below
        if(password.length() >= Min_length )
        {
            score += 2;
        }

        if (password.length() >= bonus_length)
        {
            score += 2;
        }
        
        //now we are off to check whether the password has upper case letter, lower case letter, numbers and symbols
        if(hasUpper(password))
        {
            score += 2;
        }

        if(hasLower(password))
        {
            score += 2;
        }

        if(hasNumber(password))
        {
            score += 2;
        }

        if(hasSymbol(password))
        {
            score += 2;
        }

        //we will deduct points for characters that are repeated directly one after another
        if(!hasRepeatedChars(password))
        {
            score +=2;
        }

        return score;
    }

    public static boolean hasUpper(String p)
    {
        return p.matches(".*[A-Z].*"); //regex equals to every char before A-Z then every char after
    }

    
    public static boolean hasLower(String p)
    {
        return p.matches(".*[a-z].*"); //similarly with lowercase letters
    }

    
    public static boolean hasNumber(String p)
    {
        return p.matches(".*[0-9].*");
    }
    
    public static boolean hasSymbol(String p)
    {
        return p.matches(".*[^A-Za-z0-9].*"); //^means anything but the things following so this gives back only for the symbols like !@#$%^*&* etchetera
    }

    public static boolean hasRepeatedChars(String p)
    {
        for(int i = 0; i < p.length() - 1; i++)
        {
            if(p.charAt(i) == p.charAt(i + 1))
            {
                return true;
            }
        }

        return false;
    }

    public static String classifyStrength(int score)
    {
        if (score <= 4)
        {
            return "Very weak password";
        }

        if(score <= 8)
        {
            return "Weak password";
        }

        if (score <= 12)
        {
            return "Medium password, neither terible nor great";
        }

        if (score <= 16)
        {
            return "Strong password";
        }

        return "Very strong password";
    }

    public static List<String> feedbackGeneration(String t)
    {
        List<String> feedback = new ArrayList<>();

        if(t.length() < Min_length)
        {
            feedback.add("Increase the lentgh of your password to a minimum of 8 characters.");
        }

        if(t.length() < bonus_length)
        {
            feedback.add("Even though your password has a good length it can be better. Try using more than 12 characters next time.");
        }

        if(!hasUpper(t))
        {
            feedback.add("Add at least an uppercase letter to your password.");
        }

        if(!hasLower(t))
        {
            feedback.add("Add at least an lowercase letter to your password.");
        }

        if(!hasNumber(t))
        {
            feedback.add("Add at least a number to your password.");
        }

        if(!hasSymbol(t))
        {
            feedback.add("Add at least a symbol (!@#$%^&*-) to your password.");
        }

        if(hasRepeatedChars(t))
        {
            feedback.add("Your password has repeated consecutive characters. Please change those up to improve password security.");
        }

        if(feedback.isEmpty())
        {
            feedback.add("Magnificent! Your password follows all the security requirements. I have nothing to correct!");
        }

        return feedback;
    }
}
