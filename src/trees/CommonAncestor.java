package trees;

public class CommonAncestor {

  public static TreeNode getAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root == p) {
      return p;
    }

    if (root == q) {
      return q;
    }

    TreeNode left = getAncestor(root.left, p, q);
    if (left != null && left != p && left != q) {
      return left;
    }
    TreeNode right = getAncestor(root.right, p, q);

    if (left == null && right == null) {
      return null;
    }

    if (left != null && right != null) {
      return root;
    }
    if (left == null) {
      return right;
    } else {
      return left;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    TreeNode root = TreeNode.generate();
    TreeNode.inOrder(root);
  }
}
