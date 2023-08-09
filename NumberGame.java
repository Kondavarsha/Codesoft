import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        int lowRange = 1;
        int highRange = 100;
        int limit = 10;
        int bestScore = 0;

        System.out.println("Welcome to the Number Game!");

        boolean guessAgain = true;
        while (guessAgain) {
            int actualNumber = r.nextInt(highRange - lowRange + 1) + lowRange;
            System.out.println("\nThe game is about, guessing a number between " + lowRange + " and " + highRange + ". Can you guess it? ");

            int a = 0;
            boolean correctGuess = false;
            while (!correctGuess && a < limit) {
                System.out.print("Enter your guess number: ");
                int playerGuess = scanner.nextInt();
                a++;

                if (playerGuess == actualNumber) {
                    correctGuess = true;
                    bestScore++;
                    System.out.println("Hurray! You guessed the number in " + a + " attempts.");
                } else if (playerGuess < actualNumber) {
                    System.out.println("Sorry it's too low! Try again.");
                } else {
                    System.out.println("Sorry it's too high! Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number  is: " + actualNumber);
            }

            System.out.print("Want to give an another try? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            guessAgain = playAgain.equals("yes") || playAgain.equals("y");
        }

        System.out.println("Your final score: " + bestScore);
        System.out.println("Thanks for playing! Have a nice day!");
    }
}