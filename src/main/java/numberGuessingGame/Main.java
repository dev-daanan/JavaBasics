package numberGuessingGame;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numGuessesLeft = 5;
        int guess = 0;
        Scanner scanner = new Scanner(System.in);
        boolean validInput;
        int upperBound = 100;
        int difficulty = 0;
        boolean keepPlaying = true;
        do {
            // Get difficulty
            do {
                validInput = false;
                try {
                    System.out.println("""
                            Please your desired difficulty level.
                            1. Easy (1 - 100) with 5 guesses
                            2. Medium (1 - 500) with 10 guesses
                            3. Hard (1 - 1000) with 15 guesses""");
                    difficulty = scanner.nextInt();
                    scanner.nextLine();
                    if (difficulty < 1 || difficulty > 3) {
                        System.out.println("Input out of range.");
                        continue;
                    }
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, try again.");
                    scanner.next();
                }
            } while (!validInput);
            System.out.println("-".repeat(50));

            // Set difficulty and guesses
            System.out.println("Selected difficulty is: " + difficulty);
            switch (difficulty) {
                case 2 -> {
                    upperBound = 500;
                    numGuessesLeft = 10;
                }
                case 3 -> {
                    upperBound = 1000;
                    numGuessesLeft = 15;
                }
            }
            int numGuessesOriginal = numGuessesLeft;

            // Initialize secret Number
            Random random = new Random();
            int secretNumber = random.nextInt(upperBound) + 1;
            System.out.println("secret Number: " + secretNumber);
            System.out.println("Number of Guesses: " + numGuessesLeft);
            System.out.println("-".repeat(50));
            // start game
            do {
                do {
                    validInput = false;
                    try {
                        System.out.println("Please enter your guess between 1 and " + upperBound +".");
                        guess = scanner.nextInt();
                        scanner.nextLine();

                        if (guess < 1 || guess > upperBound) {
                            System.out.println("Input out of range.");
                            continue;
                        }
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, try again.");
                        scanner.nextLine();
                    }
                } while (!validInput);
                if (guess == secretNumber) {
                    System.out.println("You've guessed the correct number!");
                    System.out.println("YOU WIN!!!");
                    break;
                } else if (guess > secretNumber) {
                    System.out.println("You've guessed too high!");
                } else if (guess < secretNumber) {
                    System.out.println("You've guessed too low!");
                }
                numGuessesLeft--;
                if (numGuessesLeft > 0) {
                    System.out.println("Guesses left: " + numGuessesLeft);
                    if ( numGuessesLeft < (numGuessesOriginal / 2) + 1) {
                        if (secretNumber%2 == 0) {
                            System.out.println("Hint: The secret number is even");
                        } else {
                            System.out.println("Hint: The secret number is odd");
                        }
                    }
                } else {
                    System.out.println("No more guesses left... YOU LOSE!");
                    System.out.println("The secret number was: " + secretNumber);
                }
            } while (numGuessesLeft > 0);

            System.out.println("Would you like to play again? Enter 'y' for yes and anything else for no.");
//            scanner.nextLine();
            String answer = scanner.nextLine();
            if (!Objects.equals(answer, "y")) {
                keepPlaying = false;
            }
        }while (keepPlaying);
    }
}
