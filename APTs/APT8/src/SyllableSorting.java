import java.util.*;

public class SyllableSorting {
    public String[] sortWords(String[] words) {
        ArrayList<Word> list = new ArrayList<>();
        for (String word: words) {
            ArrayList<String> syllables = getSyllables(word);
            ArrayList<String> sortedSyllables = new ArrayList<>(syllables);
            Collections.sort(sortedSyllables);
            list.add(new Word(word, sortedSyllables, syllables));
        }
        Collections.sort(list);
        String[] ret = new String[list.size()];
        int i = 0;
        for (Word c: list) {
            ret[i] = c.toString();
            i++;
        }
        return ret;
    }

    private class Word implements Comparable<Word> {
        private String word;
        private ArrayList<String> firstSorted;
        private ArrayList<String> firstUnsorted;
        private Word(String word, ArrayList<String> firstSorted, ArrayList<String> firstUnsorted) {
            this.word = word;
            this.firstSorted = firstSorted;
            this.firstUnsorted = firstUnsorted;
        }
        public ArrayList<String> getFirstSorted() {
            return firstSorted;
        }
        public ArrayList<String> getFirstUnsorted() {
            return firstUnsorted;
        }
        public String toString() {
            return this.word;
        }
        @Override
        public int compareTo(Word o) {
            if (this.getFirstSorted().equals(o.getFirstSorted())) {
                return String.join(" ", this.getFirstUnsorted()).compareTo(String.join(" ", o.getFirstUnsorted()));
            }
            return String.join(" ", this.getFirstSorted()).compareTo(String.join(" ", o.getFirstSorted()));
        }
    }

    private ArrayList<String> getSyllables(String word) {
        ArrayList<String> ret = new ArrayList<>();
        int start = 0;
        int end = 1;
        boolean foundVowel = false;
        boolean foundConsonant = false;
        while (end < word.length()) {
            if (containsVowel(word.substring(end, end+1))) {
                foundVowel = true;
            }
            else {
                if (foundVowel) {
                    foundConsonant = true;
                }
            }
            if (foundVowel && foundConsonant) {
                ret.add(word.substring(start, end));
                start = end;
                foundVowel = false;
                foundConsonant = false;
            }
            end++;
        }
        ret.add(word.substring(start, end));
        return ret;
    }

    private boolean containsVowel(String word) {
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
        for (char one: word.toCharArray()) {
            for (char vowel: vowels) {
                if (one == vowel) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] test = new String[] {"gawayama", "yamagawa", "xiaoxiao"};
        SyllableSorting obj = new SyllableSorting();
        System.out.println(Arrays.toString(obj.sortWords(test)));
    }
}