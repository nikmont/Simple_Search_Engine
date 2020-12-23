package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SearchController {

    private static List<String> list;
    private static final Map<String, List<Integer>> indexMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private static final Scanner scan = new Scanner(System.in);
    private static SearchStrategy currentStrategy;

    public SearchController(String file) {
        list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String word;
            while ((word = br.readLine()) != null) {
                list.add(word);
            }
        } catch (IOException ex) {
            System.out.println("File not found!");
        }

        indexing(list);
    }

    private void indexing(List<String> list) {
        for (String person:list) {
            for (String word:person.split("\\s")) {
                if (!indexMap.containsKey(word)) {
                    indexMap.put(word, new ArrayList<>());
                }
                indexMap.get(word).add(list.indexOf(person));
            }
        }
    }

    public List<String> findPerson() {

        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
        String input = scan.nextLine();
        switch (input) {
            case "ALL":
                currentStrategy = new SearchAll();
                break;
            case "ANY":
                currentStrategy = new SearchAny();
                break;
            case "NONE":
                currentStrategy = new SearchNone();
                break;
            default:
                System.out.println("Unknown strategy");
        }

       return currentStrategy.find(indexMap, list);
    }

    public List<String> getAll() {
        return list;
    }

}
