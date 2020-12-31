public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        StringBuilder str = new StringBuilder();
        for (int num: rights) {
            if (num >= minPermission) {
                str.append("A");
            }
            else {
                str.append("D");
            }
        }
        return str.toString();
    }
}