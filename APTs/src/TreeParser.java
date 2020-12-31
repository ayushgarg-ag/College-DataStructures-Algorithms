import java.util.Arrays;

public class TreeParser {
    int myIndex;
    String[] myValues;
    public  TreeNode parse(String data) {
        myValues = data.split("\\s+");
        System.out.println(Arrays.toString(myValues));
        myIndex = 0;
        return helper();
    }
    private TreeNode helper() {
        if (myIndex >= myValues.length) {
            return null;
        }
        if (myValues[myIndex].equals("x")) {
            myIndex += 1;
            return null;
        }
        int val = Integer.parseInt(myValues[myIndex]);
        myIndex += 1;
        TreeNode left = helper();
        TreeNode right = helper();
        return new TreeNode(val,left,right);
    }
    public void print(TreeNode tree) {
        if (tree != null) {
            System.out.print(tree.info+" ");
            print(tree.left);
            print(tree.right);
        }
    }

    public static void main(String[] args){
        String s = "8 4 x 6 x x 12 10 x x 15 x x";
        TreeParser t = new TreeParser();
        TreeNode tree = t.parse(s);
        t.print(tree);
    }
}
