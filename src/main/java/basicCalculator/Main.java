package basicCalculator;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the best basic calculator console program!");
        Boolean hasAnotherQuestion = true;
        Scanner s = new Scanner(System.in);
        do {
            Double firstNum = null;
            Double secondNum = null;
            Integer operationNum = null;
            Character operation = null;
            Double answer = null;

            Boolean hasFirstNum = false;
            Boolean hasSecondNum = false;
            Boolean hasOperation = false;

            do {
                try {
                    System.out.println("What is your first number?");
                    firstNum = s.nextDouble();
                    hasFirstNum = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input try again");
                    s.next();
                }

            } while (hasFirstNum == false);
            do {
                try {
                    System.out.println("""
                            What operation would you like to perform?
                            1. Addition
                            2. Subtraction
                            3. Multiplication
                            4. Division""");
                    operationNum = s.nextInt();
                    if (operationNum < 1 || operationNum > 4) {
                        System.out.println("Invalid input try again");
                        continue;
                    }
                    hasOperation = true;
                    switch(operationNum) {
                        case 1 -> operation = '+';
                        case 2 -> operation = '-';
                        case 3 -> operation = '*';
                        case 4 -> operation = '/';
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input try again");
                    s.next();
                }

            } while (hasOperation == false);
            do {
                try {
                    System.out.println("What is your second number?");
                    secondNum = s.nextDouble();
                    hasSecondNum = true;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input try again");
                    s.next();
                }

            } while (hasSecondNum == false);

            switch(operationNum) {
                case 1 -> answer = firstNum + secondNum;
                case 2 -> answer = firstNum - secondNum;
                case 3 -> answer = firstNum * secondNum;
                case 4 -> answer = firstNum / secondNum;
            }
            System.out.println(firstNum + " " + operation + " " +secondNum + " = " +answer);
            System.out.println("Do you have another calculation?\nEnter 'y' for yes and anything else for no.");
            String hasAnother = s.next();
            if (!Objects.equals(hasAnother, "y")) {
                hasAnotherQuestion = false;
            }
        } while (hasAnotherQuestion);


    }

}
/***
 * Of course! Here's a detailed blueprint for the **Basic Calculator** project:
 * **Basic Calculator Blueprint:**
 *
 * **Objective:**
 * To create a console-based calculator that lets users perform basic arithmetic operations using Java's data types, variables, operators, and I/O handling.
 * **1. Setup & Initialization:**
 * - Initialize your Java development environment.
 * - Start with the basic structure: `public static void main(String[] args)`.
 * - Import necessary classes: `import java.util.Scanner;`.
 * **2. User Input:**
 * - Use the `Scanner` class to take user inputs.
 * - Prompt the user to:
 *   - Select an arithmetic operation (e.g., 1 for addition, 2 for subtraction, etc.).
 *   - Input two numbers on which the chosen operation will be performed.
 *
 * ```java
 * Scanner scanner = new Scanner(System.in);
 * System.out.println("Choose an operation: \n1. Addition \n2. Subtraction \n3. Multiplication \n4. Division");
 * int choice = scanner.nextInt();
 * System.out.println("Enter the first number:");
 * double num1 = scanner.nextDouble();
 * System.out.println("Enter the second number:");
 * double num2 = scanner.nextDouble();
 * ```
 * **3. Arithmetic Operations:**
 * - Based on user input, apply the correct arithmetic operation using conditional statements.
 *
 * ```java
 * double result;
 * switch(choice) {
 *     case 1:
 *         result = num1 + num2;
 *         break;
 *     case 2:
 *         result = num1 - num2;
 *         break;
 *     case 3:
 *         result = num1 * num2;
 *         break;
 *     case 4:
 *         // You should check if num2 is zero to avoid dividing by zero.
 *         if (num2 != 0) {
 *             result = num1 / num2;
 *         } else {
 *             System.out.println("Cannot divide by zero!");
 *             return;
 *         }
 *         break;
 *     default:
 *         System.out.println("Invalid choice!");
 *         return;
 * }
 * ```
 *
 * ---
 *
 * **4. Displaying Results:**
 * - Display the result of the operation using `System.out.println()`.
 *
 * ```java
 * System.out.println("The result is: " + result);
 * ```
 *
 * ---
 *
 * **5. Error Handling & Input Checks:**
 * - Add error handling for unexpected inputs.
 * - For division, include a condition to check for division by zero and handle it gracefully.
 *
 * ---
 *
 * **6. Continuous Execution (Bonus)**
 * - If you're feeling ambitious, you can wrap your program in a `do-while` loop, allowing users to perform multiple operations without restarting the application. At the end of each calculation, ask the user if they want to continue.
 *
 * ---
 *
 * **7. Testing:**
 * - Test all four operations to ensure they work correctly.
 * - Test with various numbers (including edge cases like division by zero).
 * - Test the calculator's response to unexpected inputs.
 *
 * ---
 *
 * This blueprint provides a structure for your Basic Calculator project, ensuring that you touch on all the important concepts from Chapter 2. Happy coding!
 *
 * ***/