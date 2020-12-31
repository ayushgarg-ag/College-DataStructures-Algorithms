import java.util.HashSet;

public class UniqueNewYork {
    public int seen(String[] records) {
        HashSet<String> set = new HashSet<>();
        for (String record: records) {
            String[] spl = record.split(",");
            for (String one: spl) {
                set.add(one);
            }
        }

        return set.size();
    }
}