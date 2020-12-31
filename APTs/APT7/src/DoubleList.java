public class DoubleList {
    public ListNode bigify(ListNode list) {
        ListNode temp = list;
        while (temp != null) {
            temp.next = new ListNode(temp.info, temp.next);
            temp = temp.next.next;
        }
        return list;
    }
}