import java.util.HashMap;

public class IsomorphicWords {
    public int countPairs(String[] words) {
        int total = 0;

        for(int j = 0; j < words.length; j++) {
            String jword = iso(words[j]);
            for (int k = j+1; k < words.length; k+=1) {
                String kword = iso(words[k]);
                if (jword.equals(kword)) {
                    total += 1;
                }
            }
        }
        return total;
    }

    private String iso(String word) {
        String ret = "";
        HashMap<Character, Character> map = new HashMap<>();
        char counter = 'a';

        for (Character letter: word.toCharArray()) {
            if (! map.containsKey(letter)) {
                map.put(letter, counter);
                ret += counter;
                counter += 1;
            }
            else {
                ret += map.get(letter);
            }
        }

        return ret;
    }
}