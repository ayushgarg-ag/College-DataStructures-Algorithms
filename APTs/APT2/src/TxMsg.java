import java.util.ArrayList;
import java.util.List;

public class TxMsg {
    public String getMessage(String original) {
        StringBuilder ret = new StringBuilder();
        String[] words = original.split(" ");
        ArrayList<String> lst = new ArrayList<String>();
        for (String word: words) {
            lst.add(parseWord(word));
        }
        return String.join(" ", lst);
    }

    private String parseWord(String word) {
        StringBuilder ret = new StringBuilder();
        boolean existConsonants = false;

        for (int i = 0; i < word.length(); i++) {
            String ch = String.valueOf(word.charAt(i));
            if (!containsVowel(ch)) {
                if (i == 0 || containsVowel(String.valueOf(word.charAt(i-1)))) {
                    ret.append(ch);
                }
                existConsonants = true;
            }
        }
        if (!existConsonants) {
            return word;
        }
        return ret.toString();
    }

    private boolean containsVowel(String c) {
        String vowels = "aeiou";
        for (String one: vowels.split("")) {
            if(c.equals(one)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TxMsg message = new TxMsg();
        message.getMessage("text message");
    }
}