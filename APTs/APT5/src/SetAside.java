import java.util.*;

public class SetAside {
    public String common(String[] list) {
        Set<String> set = new TreeSet<>(Arrays.asList(list[0].split(" ")));
        for (int i = 1; i < list.length; i++) {
            set.retainAll(Arrays.asList(list[i].split(" ")));
        }
        return String.join(" ", set);
    }
}