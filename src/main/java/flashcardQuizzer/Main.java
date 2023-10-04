package flashcardQuizzer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flashcard flashcard_1 = new Flashcard("when do i start work?", "Teusday");
        Flashcard flashcard_2 = new Flashcard("what day is it?", "Monday");
        Flashcard flashcard_3 = new Flashcard("Fav series?", "Spellmonger series");
        Flashcard flashcard_4 = new Flashcard("eye color?", "green");
        Flashcard flashcard_5 = new Flashcard("her eye color?", "brown");
        Flashcard flashcard_6 = new Flashcard("drinks?", "tea, and bubble tea");

        ArrayList<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(flashcard_1);
        flashcards.add(flashcard_2);
        flashcards.add(flashcard_3);
        flashcards.add(flashcard_4);
        flashcards.add(flashcard_5);
        flashcards.add(flashcard_6);
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        boolean keepStudying = true;


        do {
            System.out.println("""
                    1. Create a new flashcard.
                    2. Review existing flashcards.
                    3. Quiz themselves using flashcards.
                    4. Exit the program.""");
            try {
                answer = scanner.nextInt();
                if (answer < 1 || answer > 4) {
                    System.out.println("Input out of range.");
                    continue;
                }
                switch (answer) {
                    case 1 -> flashcards.add(Main.createCard());
                    case 2 -> printDeck(flashcards);
                    case 3 -> studyTheDeck(flashcards);
                    case 4 -> keepStudying = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            }
        } while (keepStudying);
    }

    public static Flashcard createCard() {
        Scanner scanner = new Scanner(System.in);
        String question = "";
        String answer = "";
        // Get Question
        do {
            try {
                System.out.println("Enter question:");
                question = scanner.nextLine();
                if (question.isEmpty()) {
                    question = "No question provided";
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
            }
            break;
        } while (true);
        // Get Answer
        do {
            try {
                System.out.println("Enter answer:");
                answer = scanner.nextLine();
                if (answer.isEmpty()) {
                    answer = "No answer provided";
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
            }
            break;
        } while (true);

        return new Flashcard(question, answer);
    }

    public static void printDeck(ArrayList<Flashcard> deck) {
        System.out.println("-".repeat(50));
        System.out.println("Questions:");
        for (Flashcard card : deck) {
            System.out.println(card.question);
        }
        System.out.println("-".repeat(50));
    }

    public static void printDeckWithAnswer(ArrayList<Flashcard> deck) {
        System.out.println("-".repeat(50));
        System.out.println("Questions & Answers:");
        for (Flashcard card : deck) {
            System.out.println(card);
        }
        System.out.println("-".repeat(50));
    }

    public static void studyTheDeck(ArrayList<Flashcard> deck) {
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;
        for (Flashcard card : deck) {
            String correct = "";
            System.out.println("-".repeat(50));
            System.out.println("Question:");
            System.out.println("-> " + card.question);
//            System.out.println("-".repeat(50));
            System.out.println("press enter for the answer...");
            scanner.nextLine();
            System.out.println("Answer:");
            System.out.println("-> " + card.answer);
            System.out.println("-".repeat(50));
            System.out.println("Enter 'y' if you got the answer correct:");
            correct = scanner.nextLine();

            if (correct.length() > 0 && correct.charAt(0) == 'y') {
                System.out.println("Awesome! Good job on getting it right!");
                correctCount++;
            } else {
                System.out.println("That's okay, better luck next time!");
            }
        }
        System.out.println("-".repeat(50));
        System.out.println("Your score was: " + correctCount + "/" + deck.size());
        System.out.println("-".repeat(50));

    }
}












