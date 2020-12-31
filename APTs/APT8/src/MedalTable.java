import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MedalTable {
    private class MedalCountry {
        private String name;
        private int gold = 0;
        private int silver = 0;
        private int bronze = 0;
        private MedalCountry(String name) {
            this.name = name;
        }
        public int getGold() {
            return gold;
        }
        public int getSilver() {
            return silver;
        }
        public int getBronze() {
            return bronze;
        }
        public String getName() {
            return name;
        }
        public String toString() {
            return String.format("%s %d %d %d", name, gold, silver, bronze);
        }
    }

    public String[] generate(String[] results) {
        HashMap<String, MedalCountry> map = new HashMap<>();
        for (String result: results) {
            String[] data = result.split(" ");
            for (int i = 0; i < data.length; i++) {
                map.putIfAbsent(data[i], new MedalCountry(data[i]));
            }
            map.get(data[0]).gold += 1;
            map.get(data[1]).silver += 1;
            map.get(data[2]).bronze += 1;
        }

        ArrayList<MedalCountry> list = new ArrayList<>(map.values());
        Comparator<MedalCountry> gold = Comparator.comparing(MedalCountry::getGold).reversed();
        Comparator<MedalCountry> silver = Comparator.comparing(MedalCountry::getSilver).reversed();
        Comparator<MedalCountry> bronze = Comparator.comparing(MedalCountry::getBronze).reversed();
        Comparator<MedalCountry> country = Comparator.comparing(MedalCountry::getName);
        Comparator<MedalCountry> compare = gold.thenComparing(silver).thenComparing(bronze).thenComparing(country);

        Collections.sort(list, compare);
        String[] ret = new String[list.size()];
        int i = 0;
        for (MedalCountry c: list) {
            ret[i] = c.toString();
            i++;
        }
        return ret;
    }
}