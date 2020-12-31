public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        ListNode temp = list;
        while (temp != null) {
            for (int i = 0; i < amount - 1; i++) {
                temp.next = new ListNode(temp.info, temp.next);
                temp = temp.next;
            }
            temp = temp.next;
        }
        return list;
    }
}