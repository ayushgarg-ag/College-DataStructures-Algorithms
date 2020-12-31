import java.util.*;

public class AllPaths {
    ArrayList<String> myList;
    public AllPaths() {
        myList = new ArrayList<>();
    }

    public String[] paths(TreeNode tree) {
        helper(tree, "");
        String[] ret = new String[myList.size()];
        int i = 0;
        for (String str: myList) {
            ret[i] = str;
            i++;
        }
        Arrays.sort(ret);
        return ret;
    }

    private void helper(TreeNode tree, String path) {
        if (tree != null) {
            helper(tree.left, path + tree.info + "->");
            helper(tree.right, path + tree.info + "->");
            if(tree.left == null && tree.right == null) {
                myList.add(path+tree.info);
            }
        }
    }
}