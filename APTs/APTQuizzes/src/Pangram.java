import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Pangram {
    public String[] find(String[] phrases){
        TreeSet<String> sortedRet = new TreeSet<>();
        for (String phrase: phrases) {
            String lowerVersion = phrase.toLowerCase().replace(" ", "");
            HashSet<String> set = new HashSet<>(Arrays.asList(lowerVersion.split("")));
            if (set.size() >= 26) {
                sortedRet.add(phrase);
            }
        }
        return sortedRet.toArray(new String[0]);
    }
}