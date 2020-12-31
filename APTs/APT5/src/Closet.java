import java.util.*;

public class Closet {
    public String anywhere(String[] list) {
        TreeSet<String> set = new TreeSet<>();
        for (String str: list) {
            set.addAll(Arrays.asList(str.split(" ")));
        }
        return String.join(" ", set);
    }
}