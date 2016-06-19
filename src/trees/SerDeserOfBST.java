package trees;

/**
 * Created by shuailu on 6/9/16.
 */
public class SerDeserOfBST {
    public static final String SEPARATOR = ",";

    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        //if root is the root of a BST, just return the pre-order
        StringBuilder res = new StringBuilder();
        res.append(root.data);
        res.append(SEPARATOR);
        if (root.left != null) {
            res.append(serialize(root.left));
        }
        if (root.right != null) {
            res.append(serialize(root.right));
        }
        return new String(res);
    }

    public static TreeNode deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        //tokenize
        String[] tokens = str.split(SEPARATOR);
        if (tokens.length == 0) {
            return null;
        }
        int[] intTokens = new int[tokens.length];
        for (int n = 0; n < tokens.length; n++) {
            intTokens[n] = Integer.parseInt(tokens[n]);
        }
        return deserialize(intTokens, 0, intTokens.length - 1);
    }

    public static TreeNode deserialize(int[] tokens, int start, int end) {
        if (start < 0 || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(tokens[start]);
        //find the first index of right sub tree
        int runner = start +  1;
        while (runner <= end && tokens[runner] < tokens[start]) {
            runner++;
        }
        root.left = deserialize(tokens, start + 1, runner - 1);
        root.right = deserialize(tokens, runner, end);
        return root;
    }




    public static void main(String[] args) {
        //test serialize
        String str = serialize(getTree());
        System.out.println(str); // expected: 5, 4, 8, 6, 7, 9

        TreeNode root = deserialize(str);
        System.out.println(serialize(root));

    }

    public static TreeNode getTree() {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7);
        root.left = node4;
        root.right = node8;
        node8.left = node6;
        node8.right = node9;
        node6.right = node7;
        return root;
    }
}
