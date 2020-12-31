import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MemberCheck {
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {
        HashSet<String> set1 = new HashSet<>(Arrays.asList(club1));
        HashSet<String> set2 = new HashSet<>(Arrays.asList(club2));
        HashSet<String> set3 = new HashSet<>(Arrays.asList(club3));

        HashSet<String> retSet = new HashSet<>();
        retSet.addAll(intersection(set1, set2));
        retSet.addAll(intersection(set2, set3));
        retSet.addAll(intersection(set1, set3));
        String[] ret = retSet.toArray(new String[0]);
        Arrays.sort(ret);
        return ret;
    }

    private HashSet<String> intersection(HashSet<String> one, HashSet<String> two) {
        HashSet<String> onecopy = new HashSet<String>(one);
        HashSet<String> twocopy = new HashSet<String>(two);
        onecopy.retainAll(two);
        return onecopy;
    }
}