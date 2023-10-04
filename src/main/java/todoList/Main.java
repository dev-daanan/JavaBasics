package todoList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int userChoice = 0;
        ArrayList<String> todoList = new ArrayList<>();
        todoList.add("have some tea");
        todoList.add("blink my left eye");
        todoList.add("smile");
        do {
        /*
        Choices:
            1. Add a task.
            2. Mark a task as done.
            3. View all tasks.
            4. Delete a task.
            5. Exit.
        */
            userChoice = getMenuChoice();
            switch (userChoice) {
                case 1 -> addTask(todoList);
                case 2 -> markAsDone(todoList);
                case 3 -> viewTasks(todoList);
                case 4 -> deleteTask(todoList);
                case 5 -> System.out.println("Exiting application...");
            }
            System.out.println("-".repeat(50));
        } while (userChoice != 5);
    }

    public static void addTask(ArrayList<String> list) {
        System.out.println("-".repeat(50));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a new task:");
        String newTask = scanner.nextLine();
        if (newTask.isEmpty()) {
            System.out.println("no task has been entered...");
            System.out.println("returning to main menu.");
        } else {
            list.add(newTask);
            System.out.println("\"" + newTask + "\" has been added to task list.");
        }
        System.out.println("-".repeat(50));
    }

    private static void markAsDone(ArrayList<String> list) {
        System.out.println("-".repeat(50));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the index of the task completed:");
        viewTasks(list);
        int taskIndex = 0;
        do {
            try {
                taskIndex = scanner.nextInt();
                if (taskIndex < 1 || taskIndex >= list.size()) {
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.next();
            }
        } while (true);
        list.set(taskIndex - 1, "DONE: " + list.get(taskIndex - 1));
        System.out.println("Task " + taskIndex + " has been marked as done.");
        System.out.println("-".repeat(50));

    }

    private static void viewTasks(ArrayList<String> list) {
        System.out.println("-".repeat(50));
        System.out.println("Printing current list of tasks:");
        int i = 1;
        for (String todo : list) {
            System.out.println(i + ". " + todo);
            i++;
        }
        System.out.println("-".repeat(50));
    }

    private static void deleteTask(ArrayList<String> list) {
        System.out.println("-".repeat(50));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the index of the task to delete:");
        viewTasks(list);
        int taskIndex = 0;
        do {
            try {
                taskIndex = scanner.nextInt();
                if (taskIndex < 1 || taskIndex >= list.size()) {
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.next();
            }
        } while (true);
        System.out.println("Task \"" + list.get(taskIndex - 1) + "\" has been removed.");
        list.remove(taskIndex);
        System.out.println("-".repeat(50));

    }


    public static int getMenuChoice() {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        do {
            try {
                System.out.println("""
                        Please enter a number to choose:
                        1. Add a task.
                        2. Mark a task as done.
                        3. View all tasks.
                        4. Delete a task.
                        5. Exit.""");
                userChoice = scanner.nextInt();
                if (userChoice < 0 || userChoice > 5) {
                    System.out.println("Invalid Input");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.next();
                continue;
            }
            break;
        } while (true);

        return userChoice;
    }


}
