import java.util.HashMap;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        String[] arr = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String part: arr) {
            map.putIfAbsent(part, 0);
            map.put(part, map.get(part) + 1);
        }
        int[] ret = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ret[i] = map.getOrDefault(words[i], 0);
        }

        return ret;
    }
}