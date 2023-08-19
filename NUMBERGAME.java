import java.util.Random;
import java.util.Scanner;

public class NUMBERGAME
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int minRange=1;
        int maxRange=100;
        int maxAttempts=10;
        int rounds=0;
        int score=0;

        boolean playAgain=true;

        while (playAgain)
        {
            int targetNumber=random.nextInt(maxRange-minRange+1)+minRange;
            System.out.println("Round"+(rounds + 1));
            System.out.println("Guess the number between"+ minRange + "and" + maxRange);

            for(int attempts=1; attempts<=maxAttempts; attempts++)
            {
                System.out.println("Attempts"+ attempts+": Enter your guess: ");
                int userGuess=scanner.nextInt();
                if (userGuess==targetNumber)
                {
                    System.out.println("Great! You guessed the correct number in "+ attempts+ "attempts.");
                    score+=maxAttempts-attempts + 1 ;
                    break;
                }
                else if (userGuess<targetNumber)
                {
                    System.out.println("Too low. ");
                }
                else 
                {
                    System.out.println("Too high. ");
                }
                if (attempts==maxAttempts)
                {
                    System.out.println("Oh no, you were used all your attempts. The correct number was " + targetNumber);
                }
            }
            rounds++;
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainResponse=scanner.next();
            playAgain=playAgainResponse.equalsIgnoreCase("yes");
        }
        System.out.println("Game over!");
        System.out.println("Guys you Total rounds played: "+rounds);
        System.out.println("Guys you Total score: "+score);
        scanner.close();
    }
}