import java.util.HashMap;

public class BigWord {
    public String most(String[] sentences) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String sentence: sentences) {
            String[] words = sentence.split(" ");
            for (String word: words) {
                word = word.toLowerCase();
                map.putIfAbsent(word, 0);
                map.put(word, map.get(word) + 1);
            }
        }
        int max = 0;
        String maxStr = "";
        for (String word: map.keySet()) {
            if (map.get(word) > max) {
                max = map.get(word);
                maxStr = word;
            }
        }
        return maxStr;
    }
}