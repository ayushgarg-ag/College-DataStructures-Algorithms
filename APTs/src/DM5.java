import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class DM5 {
//    public ListNode copy(ListNode list) {
//        if (list == null) {
//            return null;
//        }
//        return new ListNode(list.info, copy(list.next));
//    }
//
//    public ListNode last(ListNode list) {
//        while (list.next != null) {
//            list = list.next;
//        }
//        return list;
//    }
//
//    public ListNode duplicate(ListNode list) {
//        ListNode copiedList = copy(list);
//        ListNode lastItem = last(list);
//        lastItem.next = copiedList;
//        return list;
//    }

    public ListNode listValue(int n) {
        String s = Integer.toString(n);
        ListNode first = new ListNode(s.charAt(0) - '0');
        ListNode last = first;
        for(int k=1; k < s.length(); k++){
            last.next = new ListNode(s.charAt(k) - '0');
            last = last.next;
        }
        return first;
    }

    public ListNode swapHalves(ListNode list) {
        ListNode first = list;
        ListNode temp = list;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.next != null) {
                temp = temp.next;
                list = list.next;
            }
        }
// temp points at the last node of original list
// list points at last node of the first half of original list
        ListNode second = list.next;
        list.next = null;
        temp.next = first;
        return second;
    }


    public static void main(String[] args) {
//        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3)));
        DM5 practice = new DM5();
//        ListNode result = practice.duplicate(test);
//        System.out.println(result.printList());
//        ListNode result = practice.listValue(12345);
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = practice.swapHalves(test);

        System.out.println(result.printList());
    }
}