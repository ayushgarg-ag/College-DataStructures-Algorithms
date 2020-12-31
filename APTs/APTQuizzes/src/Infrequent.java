import java.util.*;

public class Infrequent {
    public String find(String[] phrases){

        HashMap<String, Integer> map = new HashMap<>();
        for (String phrase: phrases) {
            for (String word: phrase.split(" ")) {
                word = word.toLowerCase();
                map.putIfAbsent(word, 0);
                map.put(word, map.get(word) + 1);
            }
        }

        int min = Collections.min(map.values());
        for (String word: map.keySet()) {
            if (map.get(word) == min) {
                return word;
            }
        }

        return "";
    }
}