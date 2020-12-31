import java.util.HashMap;

public class Encryption {
    public String encrypt(String message){
        String ret = "";
        HashMap<Character, Character> map = new HashMap<>();
        char counter = 'a';

        for (Character letter: message.toCharArray()) {
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