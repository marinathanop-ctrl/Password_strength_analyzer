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
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;

        for (int i = 0; i< password.length(); i ++)
        {
            char ch = password.charAt(i);

            if(Character.isUpperCase(ch))
            {
                hasUpper = true;
            }

            else if(Character.isLowerCase(ch))
            {
                hasLower = true;
            }

            else if(Character.isDigit(ch))
            {
                hasNumber = true;
            }

            else
            {
                hasSymbol = true;
            }
        }

        if(hasUpper)
        {
            score += 2;
        }

        if(hasLower)
        {
            score += 2;
        }

        if(hasNumber)
        {
            score += 2;
        }

        if(hasSymbol)
        {
            score += 2;
        }

        //we will deduct points for characters that are repeated directly one after another
        int repeatedChars = 0;

        for (int i = 0; i < password.length(); i++)
        {
            if(password.charAt(i) == password.charAt(i + 1))
            {
                repeatedChars ++;
                //i'm not using a break since i want the point deduction to happen everyt ime the program finds a repeated character
            }
        }

        score -= repeatedChars;

        return score;
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
}
