public class SoccerLeagues {
    public int[] points(String[] matches) {
        int[] ret = new int[matches.length];
        for (int i = 0; i < matches.length; i++) {
            char[] arr = matches[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[j] == 'W') {
                        ret[i] += 3;
                    }
                    if (arr[j] == 'D') {
                        ret[i] += 1;
                        ret[j] += 1;
                    }
                    if(arr[j] == 'L') {
                        ret[j] += 3;
                    }
                }
            }
        }
        return ret;
    }
}