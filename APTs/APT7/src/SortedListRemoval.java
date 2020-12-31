public class SortedListRemoval {
    public ListNode uniqify(ListNode list){
        ListNode temp = list;
        if (temp == null) { return null; }

        int value = temp.info;
        while (temp != null && temp.next != null) {
            if (temp.next.info == value) {
                temp.next = temp.next.next;
            }
            else {
                value = temp.next.info;
                temp = temp.next;
            }
        }
        return list;
    }
}