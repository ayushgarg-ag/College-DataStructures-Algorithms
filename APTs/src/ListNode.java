public class ListNode {
    int info;
    ListNode next;
    ListNode(int x){
        info = x;
    }
    ListNode(int x, ListNode node){
        info = x;
        next = node;
    }

    public String printList() {
        String ret = "";
        ListNode temp = this;
        while (temp != null) {
            ret += temp.info + " -> ";
            temp = temp.next;
        }
        return ret;
    }
}