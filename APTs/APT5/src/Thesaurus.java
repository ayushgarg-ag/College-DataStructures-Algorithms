import java.util.*;

public class Thesaurus {
    public String[] edit(String[] entry) {
        ArrayList<TreeSet<String>> list = convert(entry);

        while(true) {
            int size = list.size();
            list = combine(list);
            if (list.size() == size) break;
        }

        ArrayList<String> ret = new ArrayList<>();
        for (TreeSet<String> set: list) {
            String s = String.join(" ", set);
            ret.add(s);
        }
        Collections.sort(ret);
        return ret.toArray(new String[0]);
    }

    private ArrayList<TreeSet<String>> convert(String[] entry) {
        ArrayList<TreeSet<String>> ret = new ArrayList<>();
        for (String one: entry) {
            TreeSet<String> set = new TreeSet<>(Arrays.asList(one.split(" ")));
            ret.add(set);
        }
        return ret;
    }

    private ArrayList<TreeSet<String>> combine(ArrayList<TreeSet<String>> list) {
        ArrayList<TreeSet<String>> ret = new ArrayList<>();
        int changedI = -1;
        int changedJ = -1;
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            if (changed) {
                break;
            }
            for (int j = i + 1; j < list.size(); j++) {
                TreeSet<String> temp = new TreeSet<>(list.get(i));
                temp.retainAll(list.get(j));
                if (temp.size() >= 2) {
                    TreeSet<String> t = new TreeSet<>();
                    t.addAll(list.get(i));
                    t.addAll(list.get(j));
                    ret.add(t);
                    changedI = i;
                    changedJ = j;
                    changed = true;
                    break;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i != changedI && i != changedJ) {
                ret.add(list.get(i));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Thesaurus the = new Thesaurus();
        String[] ret = new String[]{"a b x", "h z x", "k l m", "h a t", "x t a"};
        for (String word: ret) {
            System.out.print(word + "        ");
        }
        System.out.println();
        String[] ret2 = the.edit(ret);
        for (String word: ret2) {
            System.out.println(word);
        }
    }
}