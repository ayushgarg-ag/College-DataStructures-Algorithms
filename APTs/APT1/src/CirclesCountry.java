import java.lang.*;
import java.util.HashSet;

public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
        HashSet<Integer> unique = new HashSet<>();
        for (int i = 0; i < x.length; i++) {
            if (inCircle(x[i], y[i], r[i], x1, y1)) {
                if (unique.add(i) == true) {
                    unique.add(i);
                }
                else {
                    unique.remove(i);
                }
            }
            if (inCircle(x[i], y[i], r[i], x2, y2)) {
                if (unique.add(i) == true) {
                    unique.add(i);
                }
                else {
                    unique.remove(i);
                }
            }
        }
        return unique.size();
    }

    private boolean inCircle(int cx, int cy, int cr, int x, int y) {
        double d = Math.sqrt(Math.pow(x-cx, 2) + Math.pow(y-cy, 2));
        return d <= cr;
    }

    public static void main(String[] args) {
        CirclesCountry example = new CirclesCountry();
        System.out.println(example.leastBorders(new int[]{0, -6, 6}, new int[]{0, 1, 2}, new int[]{2, 2, 2}, -5, 1, 5, 1));
    }
}