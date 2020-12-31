import java.util.*;

public class MaxLeaves {
    private ArrayList<Integer> list;

    public MaxLeaves() {
        list = new ArrayList<>();
    }
    public int[] gather(TreeNode tree) {
        int height = height(tree);
        gather(tree, height, 1);
        int[] ret = new int[list.size()];
        int i = 0;
        for (int n: list) {
            ret[i] = n;
            i++;
        }
        return ret;
    }

    private void gather(TreeNode tree, int height, int depth) {
        if (tree != null) {
            gather(tree.left, height, depth + 1);
            if (depth == height) {
                list.add(tree.info);
            }
            gather(tree.right, height, depth + 1);
        }
    }

    public int height(TreeNode tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

}

//import java.util.*;
//
//public class MaxLeaves {
//    ArrayList<Integer> list = new ArrayList<>();
//    public int[] gather(TreeNode tree) {
//        int h = height(tree);
//        //System.out.println("height = "+h);
//        helper(tree,h);
//        int ret[] = new int[list.size()];
//        for(int k=0; k < ret.length; k++) {
//            ret[k] = list.get(k);
//        }
//        return ret;
//    }
//
//    private void helper(TreeNode tree, int h) {
//        if (tree == null) return;
//        if (tree.left == null && tree.right == null && h == 1) {
//            list.add(tree.info);
//        }
//        else if (h <= 1) return;
//        helper(tree.left,h-1);
//        helper(tree.right,h-1);
//    }
//
//    public int height(TreeNode tree) {
//        if (tree == null) return 0;
//        return 1 + Math.max(height(tree.left), height(tree.right));
//    }
//}
