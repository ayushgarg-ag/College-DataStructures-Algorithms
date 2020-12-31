public class PairDown {
    public int[] fold(int[] list) {
        int len = (int)(Math.ceil((list.length/2.0)));
        int[] ret = new int[len];
        for (int i = 0; i < list.length; i += 2) {
            if (i+1 == list.length) {
                ret[i/2] = list[i];
            }
            else {
                ret[i/2] = list[i] + list[i+1];
            }
        }
        return ret;
    }
}