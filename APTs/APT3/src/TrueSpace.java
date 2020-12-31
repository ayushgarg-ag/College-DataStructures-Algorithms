public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        long total = 0;
        for (int size: sizes) {
            if (size != 0) {
                if (size <= clusterSize) {
                    total += clusterSize;
                }
                else {
                    int number = 0;
                    if (size % clusterSize == 0) {
                        number = size / clusterSize;
                    }
                    else {
                        number = 1 + (int)((double) size / clusterSize);
                    }
                    total += number*clusterSize;
                }
            }
        }
        return total;
    }
}