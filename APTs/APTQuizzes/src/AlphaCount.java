import java.util.HashMap;
import java.util.TreeSet;

public class AlphaCount {
    public int[] sizing(String[] words) {
        TreeSet<String> set = new TreeSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words) {
            set.add(word);
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
        }
        int[] ret = new int[set.size()];
        int i = 0;
        for (String word: set) {
            ret[i] = map.get(word);
            i++;
        }
        return ret;
    }
}