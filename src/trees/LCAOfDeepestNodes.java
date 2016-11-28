package trees;

/*
*
* find the lowest common ancestor of two deepest nodes in tree
* http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=148413&extra=&highlight=common%2Bancestor&page=1
* */

public class LCAOfDeepestNodes {

    private int max = 0;
    private TreeNode lca = null;

    public TreeNode getLca() {
        return lca;
    }

    public int find(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = find(node.left);
        int right = find(node.right);
        int height = Math.max(left, right) + 1;
        if ((left == 0 && right ==1) || (right == 0 && left == 1) || left == right) {
            if (height > max) {
                lca = node;
                max = height;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        LCAOfDeepestNodes lcaOfDeepestNodes = new LCAOfDeepestNodes();
        TreeNode root = TreeNode.generate();
        lcaOfDeepestNodes.find(root);
        System.out.print(lcaOfDeepestNodes.getLca().data);
    }
}
