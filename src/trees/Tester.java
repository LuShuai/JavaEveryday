package trees;

public class Tester
{

	public static void main(String[] args)
	{
		BST tree = new BST();
		
		tree.add(new TreeNode(5));
		tree.add(new TreeNode(2));
		tree.add(new TreeNode(8));
		tree.add(new TreeNode(6));
		
		TreeNode.inOrder(tree.root);

	}

}
