public class TotalLetterCount {
    public int total(String[] words, String letter) {
        int total = 0;
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (String str: words[i].split("")) {
                if (str.equals(letter)) {
                    count++;
                }
            }
            total += i*count;
        }
        return total;
    }
}