import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
    public int points(String[] player, String[] dictionary) {
        HashSet<String> unique = new HashSet<>(Arrays.asList(player));
        HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int score = 0;

        for (String word: unique) {
            if (dict.contains(word)) {
                score += word.length()*word.length();
            }
        }
        return score;
    }
}