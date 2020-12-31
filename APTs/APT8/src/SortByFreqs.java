import java.util.*;

public class SortByFreqs {
    public String[] sort(String[] data) {
        List<String> copy = Arrays.asList(data);
        HashSet<String> set = new HashSet<>(Arrays.asList(data));
        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.comparing(i -> Collections.frequency(copy, i)).reversed());
        return list.toArray(new String[0]);
    }
    // List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
    // Collections.sort(list, Map.Entry.comparingByValue(Comparator.reverseOrder()));
}