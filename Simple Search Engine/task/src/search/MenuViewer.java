package search;

import java.util.List;
import java.util.Scanner;

public class MenuViewer {

    private static SearchController controller;
    private static boolean isExit = false;
    private static final Scanner scan = new Scanner(System.in);

    public static void start(String filePath) {
        controller = new SearchController(filePath);

        while (!isExit) {
            System.out.println("\n=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");

            int userInput = Integer.parseInt(scan.nextLine());

            switch (userInput) {
                case 1:
                    List<String> found = controller.findPerson();

                    if (found != null) {
                        System.out.printf("%d persons found:%n", found.size());
                        found.forEach(System.out::println);
                    } else {
                        System.out.println("No matching people found.");
                    }
                    break;
                case 2:
                    System.out.println("\n=== List of people ===");
                    controller.getAll().forEach(System.out::println);
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.");
                    break;
            }
        }
    }
}
