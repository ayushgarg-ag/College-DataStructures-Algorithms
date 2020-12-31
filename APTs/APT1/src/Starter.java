import java.util.HashSet;

public class Starter {
    public int begins(String[] words, String first) {
        HashSet<String> unique = new HashSet();
        int count = 0;
        for (String word: words) {
            if (word.substring(0, 1).equals(first) && unique.add(word)) {
                count++;
                unique.add(word);
            }
        }
        return count;
    }
}