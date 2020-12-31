import java.util.HashMap;

public class Common {
    public int count (String a, String b) {
        int total = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch: a.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            }
            else {
                map.replace(ch, map.get(ch) + 1);
            }
        }

        for (char ch: b.toCharArray()) {
            if (map.get(ch) != null && map.get(ch) >= 1) {
                map.put(ch, map.get(ch) - 1);
                total++;
            }
        }
        return total;
    }
}