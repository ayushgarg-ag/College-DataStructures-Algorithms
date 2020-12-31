import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Practice2 {
    public static HashMap<Integer, HashSet<String>> getWords(Scanner s) {
        HashMap<Integer, HashSet<String>> map = new HashMap<>();

        while (s.hasNext()) {
            String word = s.next();
            int len = word.length();
            if (! map.containsKey(len)) {
                map.put(len, new HashSet<String>());
            }
            HashSet<String> updated = map.get(len);
            updated.add(word);
            map.put(len, updated);
        }

        return map;
    }

}
