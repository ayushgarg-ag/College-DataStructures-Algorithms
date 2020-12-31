import java.util.*;

public class ClientsList {
    public String[] dataCleanup(String[] names) {
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name.contains(",")) {
                names[i] = name.substring(name.indexOf(",") + 2) + " " + name.substring(0, name.indexOf(","));
            }
        }
        List<String> list = Arrays.asList(names);
        Comparator<String> c = Comparator.comparing((String s) -> s.substring(s.indexOf(" ") + 1))
                .thenComparing((String s) -> s.substring(0, s.indexOf(" ")));
        list.sort(c);
        return list.toArray(new String[0]);
    }
}