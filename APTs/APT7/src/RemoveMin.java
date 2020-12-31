public class RemoveMin {
    public ListNode remove (ListNode list) {
        int min = Integer.MAX_VALUE;
        ListNode temp = list;
        ListNode first = list;
        while (temp != null) {
            if (temp.info < min) {
                min = temp.info;
            }
            temp = temp.next;
        }
        while (list != null && list.next != null) {
            if (list.next.info == min) {
                list.next = list.next.next;
            }
            list = list.next;
        }
        if (first.info == min) {
            first = first.next;
        }

        return first;
    }
}