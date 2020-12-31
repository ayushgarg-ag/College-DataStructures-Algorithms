import java.util.*;

public class LeafCollector {
    public String[] getLeaves(TreeNode tree) {
        ArrayList<String> ret = new ArrayList<>();
        while (isLeaf(tree) == false) {
            List<String> list = new ArrayList<>();
            collectAndRemove(tree, list);
            String level = String.join(" ", list);
            ret.add(level);
        }
        ret.add(""+tree.info);
        tree = null;
        return ret.toArray(new String[0]);
    }

    private void collectAndRemove(TreeNode tree, List<String> list) {
        if (tree != null) {
            if (isLeaf(tree.left)) {
                list.add("" + tree.left.info);
                tree.left = null;
            }
            else {
                collectAndRemove(tree.left, list);
            }
            if (isLeaf(tree.right)) {
                list.add("" + tree.right.info);
                tree.right = null;
            }
            else {
                collectAndRemove(tree.right, list);
            }
        }
    }

    private boolean isLeaf(TreeNode tree) {
        if (tree == null) {
            return false;
        }
        if (tree.left == null && tree.right == null) {
            return true;
        }
        return false;
    }
}