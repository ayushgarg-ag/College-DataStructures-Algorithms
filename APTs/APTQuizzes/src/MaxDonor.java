import java.util.*;

public class MaxDonor {
    public String generous(String[] orgs, int[] amount) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < orgs.length; i++) {
            map.putIfAbsent(orgs[i], 0);
            map.put(orgs[i], map.get(orgs[i]) + amount[i]);
        }
        int max = Collections.max(map.values());
        for (String org: map.keySet()) {
            if (map.get(org) == max) {
                return org + ":$" + max;
            }
        }
        return "";
    }
}