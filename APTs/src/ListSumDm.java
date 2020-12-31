public class ListSumDm {
//    public int sum(ListNode list) {
//        if (list == null) {
//            return 0;
//        }
//        return list.info + sum(list.next);
//    }

//    public ListNode alter(ListNode list) {
//        if (list == null || list.next == null) {
//            return list;
//        }
//        ListNode afterMe = alter(list.next.next);
//        ListNode first = list.next;
//        list.next = afterMe;
//        first.next = list;
//        return first;
//    }

    public ListNode something(ListNode list) {
        if (list == null) return null;
        if (list.next == null) return new ListNode(list.info);
        ListNode afterMe = something(list.next);
        ListNode temp = afterMe;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(list.info);
        return afterMe;
    }

    public static void main(String[] args) {
        ListSumDm test = new ListSumDm();
//        ListNode list = new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(3))));
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

//        System.out.println(test.sum(list));
//        ListNode first = test.alter(list);
        ListNode first = test.something(list);
        System.out.println(first.printList());
    }
}
