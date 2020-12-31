import java.util.HashSet;

public class UniqueNodes {
    public int sum(ListNode list) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while (list != null) {
            if (!set.contains(list.info)) {
                sum += list.info;
            }
            set.add(list.info);
            list = list.next;
        }
        return sum;
    }
}