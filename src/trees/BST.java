package trees;

public class BST
{

	TreeNode root;
	
	public BST()
	{
		root = null;
	}
	
	public BST(TreeNode node)
	{
		root = node;
	}
	
	
	public void add(TreeNode node)
	{
		root = addHelper(root, node);
	}
	
	private TreeNode addHelper(TreeNode root, TreeNode node)
	{
		if(root == null) 
			return node;
		if(node.data <= root.data)
			root.left = addHelper(root.left,node);
		else
			root.right = addHelper(root.right,node);
		return root;
	}
	
	public int find(int value)
	{
		return findHelper(root, value);
	}
	
	private int findHelper(TreeNode root, int value)
	{
		if(root == null)
		{
			return Integer.MIN_VALUE;
		}
		if(root.data == value)
			return value;
		if(value < root.data)
			return findHelper(root.left,value);
		else //(value > root.data)
			return findHelper(root.right,value);
		
	}

}
