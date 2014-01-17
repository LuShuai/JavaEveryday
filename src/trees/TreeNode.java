package trees;

public class TreeNode
{

	public Integer data;
	
	public TreeNode left, right;
	
	public TreeNode(Integer i)
	{
		data = i;
		left = right = null;
	}
	
	
	public static TreeNode generate()
	{
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(8);
		return root;
	}
	
	public static void inOrder(TreeNode root)
	{
		if(root == null) 
			return;
		inOrder(root.left);
		System.out.print("["+root.data+"]");
		inOrder(root.right);
	}

}
