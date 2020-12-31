public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        int longestIndex = -1;
        int longestValue = 0;

        for (int i = 0; i < strands.length; i++) {
            int count = 0;
            for (char ch: strands[i].toCharArray()) {
                if (ch == nuc.charAt(0)) {
                    count++;
                }
            }
            if (count > longestValue) {
                longestValue = count;
                longestIndex = i;
            }
            else if (count == longestValue && count != 0) {
                longestIndex = (strands[i].length() >= strands[longestIndex].length()) ? i : longestIndex;
            }
        }
        return (longestIndex == -1) ? "" : strands[longestIndex];
    }

    public static void main(String[] args) {
        DNAMaxNucleotide dna = new DNAMaxNucleotide();
        System.out.println(dna.max(new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "cccccc"}, "c"));
    }
}