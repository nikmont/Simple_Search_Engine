package search;

import java.util.List;
import java.util.Map;

public class SearchNone implements SearchStrategy {

    @Override
    public List<String> find(Map<String, List<Integer>> map, List <String> target) {

        founded.clear();
        System.out.println("\nEnter a name or email to search all suitable people.");
        String[] queries = scan.nextLine().trim().split("\\s");
        founded.addAll(target);

        for (String word:queries) {
            if (map.containsKey(word)) {
                for (Integer index:map.get(word)) {
                    founded.remove(target.get(index));
                }
            }
        }

        if (founded.size() > 0) {
            return founded;
        } else {
            return null;
        }
    }

}
