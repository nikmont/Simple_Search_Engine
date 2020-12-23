package search;

import java.util.*;

public class SearchAll implements SearchStrategy {

    @Override
    public List<String> find(Map<String, List<Integer>> map, List <String> target) {
        founded.clear();
        System.out.println("\nEnter a name or email to search all suitable people.");
        String[] queries = scan.nextLine().split("\\s");
        Set<Integer> indexes = new HashSet<>();

        for (int i = 0; i < queries.length; i++) {
            String word = queries[i];
            if (map.containsKey(word)) {
                if (i == 0) {
                    indexes.addAll(map.get(word));
                }
                indexes.retainAll(map.get(word));
            }
        }

        for (int i:indexes) {
            founded.add(target.get(i));
        }

        if (founded.size() > 0) {
            return founded;
        } else {
            return null;
        }
    }

}
