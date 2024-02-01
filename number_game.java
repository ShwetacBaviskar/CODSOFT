import java.util.Scanner;
import java.util.Random;
public class number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nI've picked a number between " + minRange + " and " + maxRange + ". Can you guess it?");

            for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
                System.out.print("Attempt #" + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    score += attemptsLimit - attempts + 1; // Score calculation
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + generatedNumber + ".");
                }
            }
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);
        System.out.println("Game over. Your total score is: " + score);
        scanner.close();
    }
    }
