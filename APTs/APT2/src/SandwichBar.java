import java.util.*;
import java.util.Arrays;

public class SandwichBar {
    public int whichOrder(String[] available, String[] orders){
        for (int i = 0; i < orders.length; i++) {
            if (canMake(available, orders[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean canMake(String[] available, String order) {
        String[] orderItems = order.split(" ");
        List<String> list = Arrays.asList(available);
        for (String item: orderItems) {
            if (!list.contains(item)) {
                return false;
            }
        }
        return true;
    }
}