import java.util.Arrays;
import java.util.TreeSet;

public class AlphaLength {
    public ListNode create (String[] words) {
        TreeSet<String> set = new TreeSet<>(Arrays.asList(words));
        boolean fir = true;
        ListNode first = new ListNode(0, null);
        ListNode temp = first;
        for (String a: set) {
            if (fir) {
                temp.info = a.length();
                fir = false;
            }
            else {
                ListNode toAdd = new ListNode(a.length(), null);
                temp.next = toAdd;
                temp = temp.next;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        String[] words = new String[4];
        words[0] = "bat";
        words[1] = "at";
        words[2] = "spat";
        words[3] = "expat";
        AlphaLength alpha = new AlphaLength();
        ListNode ret = alpha.create(words);
        while (ret != null) {
            System.out.println(ret.info);
            ret = ret.next;
        }
    }
}