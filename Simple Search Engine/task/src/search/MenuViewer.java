package search;

import java.util.List;
import java.util.Scanner;

public class MenuViewer {

    public static Strategy currentStrategy;

    private static boolean isExit = false;
    private static final Scanner scan = new Scanner(System.in);

    public static void start(String filePath) {
        SearchController.addData(filePath);

        while (!isExit) {
            System.out.println("\n=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");

            int userInput = Integer.parseInt(scan.nextLine());

            switch (userInput) {
                case 1:
                    String input = scan.nextLine();
                    switch (input) {
                        case "ALL":
                            currentStrategy = Strategy.ALL;
                            break;
                        case "ANY":
                            currentStrategy = Strategy.ANY;
                            break;
                        case "NONE":
                            currentStrategy = Strategy.NONE;
                            break;
                        default:
                            System.out.println("Unknown strategy");
                    }

                    List<String> found = SearchController.findPerson();
                    if (found != null) {
                        found.forEach(System.out::println);
                    } else {
                        System.out.println("No matching people found.");
                    }
                    break;
                case 2:
                    System.out.println("\n=== List of people ===");
                    SearchController.getAll().forEach(System.out::println);
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
