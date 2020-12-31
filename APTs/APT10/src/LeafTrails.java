import java.util.TreeMap;

public class LeafTrails {
    TreeMap<Integer, String> myMap;
    public LeafTrails() {
        myMap = new TreeMap<>();
    }
    public String[] trails(TreeNode tree) {
        helper(tree, "");
        String[] arr = new String[myMap.keySet().size()];
        int i = 0;
        for (int value: myMap.keySet()) {
            arr[i] = myMap.get(value);
            i++;
        }
        return arr;
    }
    public void helper(TreeNode tree, String path) {
        if (tree == null) {
            return;
        }
        if (tree.right == null && tree.left == null) {
            myMap.put(tree.info, path);
        }
        else {
            helper(tree.left, path+"0");
            helper(tree.right, path+"1");
        }
    }
}