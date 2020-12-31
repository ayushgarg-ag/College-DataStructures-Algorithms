public class TreeNode {
    int info;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        info = x;
    }
    TreeNode(int x, TreeNode lNode, TreeNode rNode){
        info = x;
        left = lNode;
        right = rNode;
    }

//    public String visualize(TreeNode tree) {
//        if (tree == null) {
//            return "";
//        }
//        String ret = "";
//        ret += visualize(tree.left);
//        ret += " " + tree.info + " ";
//        ret += visualize(tree.right);
//        return ret;
//    }
}