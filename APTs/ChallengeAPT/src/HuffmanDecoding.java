import java.util.HashMap;
import java.util.Map;

public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {
        Map<String, String> map = new HashMap<>();
        char c = 'A';

        for (String word: dictionary) {
            map.putIfAbsent(word, Character.toString(c));
            c++;
        }

        String ret = "";
        while (archive.length() > 0) {
            String nextChar = getMatch(archive, dictionary);
            ret += map.get(nextChar);
            archive = archive.substring(nextChar.length());
        }
        return ret;
    }

    private String getMatch(String archive, String[] dictionary) {
        for (String word: dictionary) {
            int len = word.length();
            if (len <= archive.length() && archive.substring(0, len).equals(word)) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        HuffmanDecoding test = new HuffmanDecoding();
        System.out.println(test.decode("10111010", new String[]{"0","111","10"}));
    }
}