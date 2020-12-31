import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordScore {
    public int[] score(String[] words, String want, String avoid) {
        int[] ret = new int[words.length];
        HashSet<String> wantLetters = new HashSet<>(Arrays.asList(want.split("")));
        HashSet<String> avoidLetters = new HashSet<>(Arrays.asList(avoid.split("")));
        int i = 0;
        for (String word: words) {
            int score = 0;
            for (String letter: word.split("")) {
                if (wantLetters.contains(letter)) {
                    score += 1;
                }
                if (avoidLetters.contains(letter)) {
                    score -= 1;
                }
            }
            ret[i] = score;
            i++;
        }

        return ret;
    }
}