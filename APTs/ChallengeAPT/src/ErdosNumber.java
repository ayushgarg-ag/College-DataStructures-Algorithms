import java.util.*;

public class ErdosNumber {
    HashMap<String, HashSet<String>> map;
    HashSet<String> allNames;

    public ErdosNumber() {
        map = new HashMap<>();
        allNames = new HashSet<>();
    }

    public String[] calculateNumbers(String[] pubs) {
        for (String pub: pubs) {
            String[] authors = pub.split(" ");
            for (String author: authors) {
                allNames.add(author);
                for (String inAuthor: authors) {
                    if (! author.equals(inAuthor)) {
                        map.putIfAbsent(author, new HashSet<>());
                        map.get(author).add(inAuthor);
                    }
                }
            }
        }
        ArrayList<String> ret = new ArrayList<>();
        for (String name: allNames) {
            int dist = distanceFromErdos(name);
            if (dist == -1) {
                ret.add(name);
            }
            else {
                ret.add(name + " " + dist);
            }
        }
        Collections.sort(ret);
        return ret.toArray(new String[0]);
    }

    public int distanceFromErdos(String name) {
        if (name.equals("ERDOS")) {
            return 0;
        }
        int count = 1;

        if (map.containsKey("ERDOS") == false) {
            return -1;
        }
        HashSet<String> set = new HashSet<>(map.get("ERDOS"));
        Queue<String> queue = new LinkedList<>(set);
        HashSet<String> alreadyDequeued = new HashSet<>();

        while (! set.contains(name)) {
            HashSet<String> toQueue = new HashSet<>();
            boolean somethingNew = false;
            while (queue.size() > 0) {
                String dequeued = queue.remove();
                alreadyDequeued.add(dequeued);
                if (map.containsKey(dequeued)) {
                    set.addAll(map.get(dequeued));
                    toQueue.addAll(map.get(dequeued));
                    somethingNew = true;
                }
            }
            if (somethingNew == false) {
                return -1;
            }

            for (String one: toQueue) {
                if (! alreadyDequeued.contains(one)) {
                    queue.add(one);
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ErdosNumber test = new ErdosNumber();
        String[] res = test.calculateNumbers(new String[] {"ERDOS B", "A B C", "B A E", "D F"});

        for (String r: res) {
            System.out.println(r);
        }
    }
}