public class ListLastFirst {
    public ListNode move(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode first = list;
        while (list.next.next != null) {
            list = list.next;
        }
        list.next.next = first;
        first = list.next;
        list.next = null;
        return first;
    }
}