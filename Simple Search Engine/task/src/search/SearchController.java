package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SearchController {
    private static List<String> list;
    private static final Map<String, List<Integer>> persons = new HashMap<>();
    private static final Scanner scan = new Scanner(System.in);

    public static void addData(String file) {
        list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String word;
            while ((word = br.readLine()) != null) {
                list.add(word);
            }
        } catch (IOException ex) {
            System.out.println("File not found!");
        }

        indexList(list);

    }

    private static void indexList(List<String> list) {
        for (String person:list) {
            for (String word:person.split("\\s")) {
                if (!persons.containsKey(word)) {
                    persons.put(word, new ArrayList<>());
                }
                persons.get(word).add(list.indexOf(person));
            }
        }
    }

    public static List<String> findPerson() {
        
        List<String> founded = new ArrayList<>();

        System.out.println("\nEnter a name or email to search all suitable people.");
        String toSearch = scan.nextLine();

        for (Map.Entry<String, List<Integer>> person : persons.entrySet()) {
            if (person.getKey().equalsIgnoreCase(toSearch)) {
                for (Integer index:person.getValue()) {
                    founded.add(list.get(index));
                }
            }
        }

        if (founded.size() > 0) {
            return founded;
        } else {
            return null;
        }
    }

    public static List<String> getAll() {
        return list;
    }

}
