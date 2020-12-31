import java.io.*;
import java.util.*;

public class Puzzler {
    public void findPairs() throws FileNotFoundException {
        File f = new File("./data/wordslower.txt");
        Scanner s = new Scanner(f);

        HashSet<String> words = new HashSet<>();
        while (s.hasNext()) {
            words.add(s.next());
        }

        String vowels = "aeiou";
        int counter = 0;

        for (String word: words) {
            for (char vowel: vowels.toCharArray()) {
                for (int i = 0; i < word.length(); i++) {
                    if (isConsonant(word.substring(i, i+1))) {
                        String check = word.substring(0, i) + vowel + word.substring(i+1);
                        if (words.contains(check)) {
                            System.out.println(word + "," + check);
                            counter++;
                        }
                    }
                }
            }
        }
        System.out.println("total = " + counter);
    }

    private boolean isConsonant(String word) {
        String vowels = "aeiou";
        for (char vowel: vowels.toCharArray()) {
            String v = Character.toString(vowel);
            if (word.contains(v)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Puzzler p = new Puzzler();
        p.findPairs();
    }
}
