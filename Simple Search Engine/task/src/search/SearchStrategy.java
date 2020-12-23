package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface SearchStrategy {
    List<String> founded = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    List<String> find(Map<String, List<Integer>> map, List <String> target);
}
