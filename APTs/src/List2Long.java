public class List2Long {
    public long convert(ListNode list) {
        long ret = 0;

        while (list != null) {
            ret = ret*10 + list.info;
            list = list.next;
        }

        return ret;
    }
}