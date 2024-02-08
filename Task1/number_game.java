import java.util.Scanner;
import java.util.Random;
public class number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int Limit = 5;
        int score = 0;
        System.out.println("######Welcome to our the Number Guessing Game!#######");
        do {
            int generatedNumber = random.nextInt(max- min + 1) + min;
            System.out.println("\nI've picked a number between " + min+ " and " + max + ". Can you guess it?");

            for (int attempts = 1; attempts <= Limit; attempts++) {
                System.out.print("Attempt #" + attempts + ": Enter your guess number: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    score += Limit - attempts + 1; // Score calculation
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("=====Too low please guess high number. Try again.======");
                } else {
                    System.out.println("======Too high please guess low number .Try again.======");
                }

                if (attempts == Limit) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + generatedNumber + ".");
                    System.out.println("🙏 🙏 🙏 🙏 🙏Thank you for playing number game");
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
