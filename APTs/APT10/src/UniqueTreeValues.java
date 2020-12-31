import java.util.TreeSet;

public class UniqueTreeValues {
    private TreeSet<Integer> mySet;
    public UniqueTreeValues() {
        mySet = new TreeSet<>();
    }
    public int[] unique(TreeNode root) {
        helper(root);
        int[] arr = new int[mySet.size()];
        int i = 0;
        for (int value: mySet) {
            arr[i] = value;
            i++;
        }
        return arr;
    }
    private void helper(TreeNode root) {
        if (root != null) {
            helper(root.left);
            mySet.add(root.info);
            helper(root.right);
        }
    }
}