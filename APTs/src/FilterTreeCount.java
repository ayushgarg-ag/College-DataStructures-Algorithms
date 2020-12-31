public class FilterTreeCount {
    public int count(TreeNode tree, int low, int high) {
        if (tree == null) {
            return 0;
        }
        int left = count(tree.left, low, high);
        int right = count(tree.right, low, high);
        if (tree.info >= low && tree.info <= high) {
            return 1 + left + right;
        }
        return left + right;
    }
}

//public class FilterTreeCount {
//    public int count(TreeNode tree, int low, int high) {
//        if (tree == null) return 0;
//        int count = 0;
//        if (low <= tree.info && tree.info <= high) count = 1;
//        return count + count(tree.left,low,high) + count(tree.right,low,high);
//    }
//}
