import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Practice {
    public String maxKey(HashMap<String,ArrayList<String>> map) {
        HashMap<String, Integer> lengthMap = new HashMap<>();
        for (String key: map.keySet()) {
            lengthMap.put(key, map.get(key).size());
        }
        int max = Collections.max(lengthMap.values());
        for (String key: lengthMap.keySet()) {
            if (lengthMap.get(key) == max) {
                return key;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Practice p = new Practice();
        HashMap<String,ArrayList<String>> mappy = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("c");
        list2.add("d");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("e");
        list3.add("f");
        list3.add("g");


        mappy.put("halogen", list);
        mappy.put("alkali", list2);
        mappy.put("noble", list3);

        System.out.println(p.maxKey(mappy));
    }

}
