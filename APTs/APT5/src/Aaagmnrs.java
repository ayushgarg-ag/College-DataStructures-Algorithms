import java.util.*;

public class Aaagmnrs {
    public String[] anagrams(String[] phrases) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> ret = new ArrayList<>();

        for (String phrase: phrases) {
            String[] str = phrase.replaceAll(" ", "").toLowerCase().split("");
            Arrays.sort(str);
            String test = String.join(" ", str);

            if (set.add(test)) {
                set.add(test);
                ret.add(phrase);
            }
        }
        return ret.toArray(new String[0]);
    }
}