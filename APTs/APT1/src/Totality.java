public class Totality {
    public int sum(int[] a, String stype) {
        int start = 0;
        int interval = 1;
        int sum = 0;

        if (stype.equals("odd")) {
            start = 1;
            interval = 2;
        }
        else if (stype.equals("even")) {
            interval = 2;
        }
        for (int i = start; i < a.length; i += interval) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Totality test = new Totality();
        System.out.println(test.sum(new int[]{1, 2, 3, 4, 5}, "even"));
    }
}