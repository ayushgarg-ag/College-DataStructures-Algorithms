import java.util.*;

public class HashListAutocomplete implements Autocompletor {
    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;

    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms == null || weights == null) {
            throw new NullPointerException("One or more arguments null");
        }

        if (terms.length != weights.length) {
            throw new IllegalArgumentException("terms and weights are not the same length");
        }
        initialize(terms,weights);
    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        myMap = new HashMap<>();
        for (int w = 0; w < terms.length; w++) {
            String term = terms[w];
            double weight = weights[w];
            for (int i = 0; i <= Math.min(term.length(), MAX_PREFIX); i++) {
                myMap.putIfAbsent(term.substring(0, i), new ArrayList<>());
                myMap.get(term.substring(0, i)).add(new Term(term, weight));
            }
        }
        for (String term: myMap.keySet()) {
            Collections.sort(myMap.get(term),Comparator.comparing(Term::getWeight).reversed());
        }
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if (k == 0 || myMap.get(prefix) == null) { return new ArrayList<>(); }
        List<Term> all = myMap.get(prefix);
        List<Term> list = all.subList(0, Math.min(k, all.size()));
        return list;
    }

    @Override
    public int sizeInBytes() {
        if (mySize == 0) {
            for (String prefix: myMap.keySet()) {
                mySize += BYTES_PER_CHAR*prefix.length();
                for(Term t : myMap.get(prefix)) {
                    mySize += BYTES_PER_DOUBLE + BYTES_PER_CHAR*t.getWord().length();
                }
            }
        }
        return mySize;
    }
}
