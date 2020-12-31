import java.util.*;
import java.util.stream.Collectors;
import java.util.*;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        int bought = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < votes.length; i++) {
            list.add(votes[i]);
        }
        while (! haveWonYet(votes)) {
            int maxIndex = list.lastIndexOf(Collections.max(list));
            list.set(maxIndex, list.get(maxIndex) - 1);
            bought++;
            votes[0]++;
            votes[maxIndex]--;
        }
        return bought;
    }

    private boolean haveWonYet(int[] votes) {
        int voteCount = votes[0];
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] >= voteCount) {
                return false;
            }
        }
        return true;
    }
}