import java.util.*;

public class VowelSort {
    public String[] sort(String[] list) {
        ArrayList<SpecialWord> ret = new ArrayList<>();
        for (String word: list ){
            ret.add(new SpecialWord(word));
        }
        Collections.sort(ret);
        String[] arr = new String[ret.size()];
        int i = 0;
        for (SpecialWord word: ret) {
            arr[i] = word.word;
            i++;
        }
        return arr;
    }

    public class SpecialWord implements Comparable {
        private String word;
        public SpecialWord(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Object o) {
            SpecialWord otherWord = (SpecialWord)(o);
            String myFirst = word.substring(0, 1);
            String otherFirst = otherWord.word.substring(0, 1);
            System.out.println(myFirst);
            System.out.println(otherFirst);
            if (isVowel(myFirst) && ! isVowel(otherFirst)) {
                return -1;
            }
            else if (! isVowel(myFirst) && isVowel(otherFirst)) {
                return 1;
            }
            return word.compareTo(otherWord.word);
        }

        public boolean isVowel(String c) {
            if (c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")) {
                return true;
            }
            return false;
        }
    }
}

//import java.util.*;
//
//public class VowelSort {
//    public class Comp implements Comparator<String> {
//        public int compare(String a, String b) {
//            char a0 = a.charAt(0);
//            char b0  = b.charAt(0);
//            boolean av = "aeiou".indexOf(a0) >= 0;
//            boolean bv = "aeiou".indexOf(b0) >= 0;
//
//            // if statements here
//            if (av && bv) return a.compareTo(b);
//            if (!av && !bv) return a.compareTo(b);
//            if (av) return -1;
//
//            return 1;
//        }
//    }
//    public String[] sort(String[] list) {
//        Arrays.sort(list, new Comp());
//        return list;
//    }
//}
