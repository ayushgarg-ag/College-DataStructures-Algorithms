/**
 * The SlowBruteAutocomplete does indeed run slower than BruteAutcomplete when we have a lot of matches.
 * This makes sense because we are sorting all of the matches and then grabbing the top k
 * vs. just maintaining the top k in a PriorityQueue while we go through the entire M matches
 * @author Ayush Garg
 */

import java.util.*;

public class SlowBruteAutocomplete extends BruteAutocomplete {

    public SlowBruteAutocomplete(String[] terms, double[] weights) {
        super(terms, weights);
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        List<Term> list = new ArrayList<>();
        for (Term t: myTerms) {
            if (t.getWord().startsWith(prefix)) {
                list.add(t);
            }
        }
        Collections.sort(list, Comparator.comparing(Term::getWeight).reversed());
        return list.subList(0, Math.min(k, list.size()));
    }
}
