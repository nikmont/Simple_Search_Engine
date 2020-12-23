package search;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchAny implements SearchStrategy {

    @Override
    public List<String> find(Map<String, List<Integer>> map, List <String> target) {

        founded.clear();
        System.out.println("\nEnter a name or email to search all suitable people.");
        String[] queries = scan.nextLine().split("\\s");
        Set<Integer> indexes = new HashSet<>();

        for (String word:queries) {
            if (map.containsKey(word)) {
                indexes.addAll(map.get(word));
            }
        }

        for (int i : indexes) {
            founded.add(target.get(i));
        }

        if (founded.size() > 0) {
            return founded;
        } else {
            return null;
        }
    }
}
