package trees;

public class Merge2BST
{
	
	public static TreeNode merge(TreeNode n1, TreeNode n2)
	{
		if(n1 == null)
			return n2;
		if(n2 == null)
			return n1;
		
		if(n2.data > n1.data)
		{
			TreeNode temp = n2.left;
			n2.left = null;
			n1.right = merge(n1.right, n2);
			n1 = merge(n1, temp);
			return n1;
		}
		else if(n2.data < n1.data)
		{
			TreeNode temp = n2.right;
			n2.right = null;
			n1.left = merge(n1.left, n2);
			n1 = merge(n1, temp);
			return n1;
		}
		else
		{
			n1.left = merge(n1.left, n2.left);
			n1.right = merge(n1.right, n2.right);
			return n1;
		}
	}

	
	public static void main(String[] args)
	{
		

	}

}
