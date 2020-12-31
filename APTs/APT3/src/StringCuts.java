import java.util.ArrayList;
import java.util.HashSet;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> unique = new ArrayList<>();
        for (String word: list) {
            if (word.length() >= minLength && !set.contains(word)) {
                unique.add(word);
            }
            set.add(word);
        }
        return unique.toArray(new String[0]);
    }
}