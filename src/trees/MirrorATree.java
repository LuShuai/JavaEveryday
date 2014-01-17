package trees;

public class MirrorATree
{

	public static TreeNode getMirror(TreeNode root)
	{
		if(root == null)
			return null;
		TreeNode temp = root.left;
		root.left = getMirror(root.right);
		root.right = getMirror(temp);
		return root;
	}
	
	public static TreeNode copyMirror(TreeNode root)
	{
		if(root == null)
			return null;
		TreeNode newRoot = new TreeNode(root.data);
		newRoot.left = copyMirror(root.right);
		newRoot.right = copyMirror(root.left);
		return newRoot;
	}
	
	public static void main(String[] args)
	{
		TreeNode root = TreeNode.generate();
		TreeNode root2 = copyMirror(root);
		TreeNode.inOrder(root2);
	}

}
