import java.util.ArrayList;
import java.util.Collections;

public class SerialNumbers {
    public String[] sortSerials(String[] numbers) {
        ArrayList<SerialNumber> list = new ArrayList<>();
        for (String number: numbers) {
            list.add(new SerialNumber(number));
        }
        Collections.sort(list);
        String[] ret = new String[numbers.length];
        int i = 0;
        for (SerialNumber one: list) {
            ret[i] = one.serial;
            i++;
        }
        return ret;
    }

    public class SerialNumber implements Comparable {
        private String serial;
        private int sum;

        public SerialNumber(String characters) {
            serial = characters;
            for (int i = 0; i < characters.length(); i++) {
                char c = characters.charAt(i);
                if (Character.isDigit(c)) {
                    sum += Integer.parseInt(characters.substring(i, i+1));
                }
            }
        }

        @Override
        public int compareTo(Object o) {
            SerialNumber otherSerial = (SerialNumber)o;
            if (serial.length() > otherSerial.serial.length()) {
                return 1;
            }
            else if (serial.length() < otherSerial.serial.length()) {
                return -1;
            }
            else {
                if (sum > otherSerial.sum) {
                    return 1;
                }
                else if (sum < otherSerial.sum) {
                    return -1;
                }
                else {
                    return serial.compareTo(otherSerial.serial);
                }
            }
        }
    }
}

//import java.util.*;
//
//public class SerialNumbers {
//    private int sum(String s) {
//        int t = 0;
//        for(char ch : s.toCharArray()) {
//            if (Character.isDigit(ch)) t += ch-'0';
//        }
//        return t;
//    }
//    public class Comp implements Comparator<String> {
//        public int compare(String a, String b) {
//            int diff = a.length() - b.length();
//            if (diff != 0) return diff;
//            diff = sum(a) - sum(b);
//            if (diff != 0) return diff;
//            return a.compareTo(b);
//        }
//    }
//    public String[] sortSerials(String[] numbers) {
//        Arrays.sort(numbers,new Comp());
//        return numbers;
//    }
//}
