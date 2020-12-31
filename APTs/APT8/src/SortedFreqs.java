import java.util.*;

public class SortedFreqs {
    public int[] freqs(String[] data) {
        HashMap<String, Integer> map = new HashMap<>();
        TreeSet<String> set = new TreeSet<>();
        for (String d: data) {
            map.putIfAbsent(d, 0);
            map.put(d, map.get(d) + 1);
            set.add(d);
        }
        int[] ret = new int[set.size()];
        int i = 0;
        for (String val: set) {
            ret[i] = map.get(val);
            i++;
        }
        return ret;
    }
}