import java.util.*;

public class OlympicCandles{
    public int numberOfNights(int[] candles){
        int number = 0;

        for(int i = 1; i <= candles.length; i++) {
            Arrays.sort(candles);
            for (int j = 0; j < i; j++) {
                int last = candles.length-1-j;
                if (candles[last] <= 0) {
                    return number;
                }
                candles[last]--;
            }
            number++;
        }
        return number;
    }

    public static void main(String[] args) {
        OlympicCandles test = new OlympicCandles();
        test.numberOfNights(new int[] {100, 99, 1, 1, 1, 1 });
    }
}