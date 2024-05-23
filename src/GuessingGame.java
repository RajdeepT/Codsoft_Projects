import java.util.Random;
import java.util.Scanner;

public class GuessingGame
{
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("A new number has been generated! Try to guess it.");

            while (attempts < MAX_ATTEMPTS && !roundWon) {
                System.out.print("Enter your guess (" + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    roundWon = true;
                    roundsWon++;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!roundWon) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You won " + roundsWon + " round(s).");
        scanner.close();
    }
}