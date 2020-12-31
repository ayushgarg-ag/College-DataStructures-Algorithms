public class MergeLists {
    public ListNode weave (ListNode a, ListNode b) {
        ListNode first = new ListNode(a.info, null);
        ListNode temp = first;
        a = a.next;
        int count = 1;

        while (a != null || b != null) {
            ListNode toAdd;
            if (count % 2 == 0) {
                // add from a
                toAdd = new ListNode(a.info);
                a = a.next;
            }
            else {
                // add from b
                toAdd = new ListNode(b.info);
                b = b.next;
            }
            count++;
            temp.next = toAdd;
            temp = temp.next;
        }
        return first;
    }
}