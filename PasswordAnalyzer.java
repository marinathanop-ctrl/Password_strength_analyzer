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

    public int calculateScore(String password)
    {
        int score = 0;

        if(password.length() >= Min_length )
        {
            score += 2;
        }

        if (password.length() >= bonus_length)
        {
            score += 2;
        }



        return score;
    }

    public String classifyStrength(int score)
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