public class HeightLabel {
    public TreeNode rewire(TreeNode t) {
        return new TreeNode(height(t), helper(t.left), helper(t.right));
    }

    private TreeNode helper(TreeNode t) {
        if (t == null) {
            return null;
        }
        t = new TreeNode(height(t), helper(t.left), helper(t.right));
        return t;
    }

    private int height(TreeNode t) {
        if (t == null) {
            return 0;
        }
        return 1 + Math.max(height(t.left), height(t.right));
    }
}