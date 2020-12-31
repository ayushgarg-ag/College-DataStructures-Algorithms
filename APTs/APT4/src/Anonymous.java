import java.util.HashMap;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        HashMap<Character, Integer> headlinesMap = getHeadlinesMap(headlines);
        int total = 0;
        for (String message: messages) {
            HashMap<Character, Integer> messageMap = getMessageMap(message);
            boolean works = true;
            for (char letter: messageMap.keySet()) {
                if (letter != ' ') {
                    if (! headlinesMap.containsKey(letter) || headlinesMap.get(letter) == 0 || headlinesMap.get(letter) < messageMap.get(letter)) {
                        works = false;
                        break;
                    }
                }
                messageMap.put(letter, messageMap.get(letter) - 1);
            }
            if (works) total+=1;
        }
        return total;
    }

    private HashMap<Character, Integer> getHeadlinesMap(String[] sentences) {
        HashMap<Character, Integer> ret = new HashMap<>();
        for (String sentence: sentences) {
            for (Character letter: sentence.toCharArray()) {
                letter = Character.toLowerCase(letter);
                ret.putIfAbsent(letter, 0);
                ret.put(letter, ret.get(letter) + 1);
            }
        }
        return ret;
    }

    private HashMap<Character, Integer> getMessageMap(String sentence) {
        HashMap<Character, Integer> ret = new HashMap<>();
        for (Character letter: sentence.toCharArray()) {
            letter = Character.toLowerCase(letter);
            ret.putIfAbsent(letter, 0);
            ret.put(letter, ret.get(letter) + 1);
        }
        return ret;
    }
}