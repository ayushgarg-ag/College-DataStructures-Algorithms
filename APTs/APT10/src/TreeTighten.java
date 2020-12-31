public class TreeTighten {
    public TreeNode tighten(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        tree.left = tighten(tree.left);
        tree.right = tighten(tree.right);
        if (tree.left == null && tree.right != null) {
            tree = tree.right;
        }
        else if (tree.right == null && tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }
}