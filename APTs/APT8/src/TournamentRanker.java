import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TournamentRanker  {
    public String[] rankTeams(String[] names, String[] lostTo) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> ret = new ArrayList<>();
        for (String name: names) {
            map.putIfAbsent(name, 0);
        }
        for (String name: lostTo) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            }
        }
        int max = Collections.max(map.values());
        for (int i = max; i >= 0; i--) {
//            ArrayList<String> sameLosses = new ArrayList<>();
            for (String name: map.keySet()) {
                if (map.get(name) == i) {
//                    sameLosses.add(name);
                    ret.add(name);
                }
            }
//            ArrayList<String> correctOrder = checkSame(sameLosses, names, lostTo);
//            ret.addAll(correctOrder);
        }
        return ret.toArray(new String[0]);
    }

//    private ArrayList<String> checkSame(ArrayList<String> sameLossTeams, String[] names, String[] lostTo) {
//        for ()
//    }
}