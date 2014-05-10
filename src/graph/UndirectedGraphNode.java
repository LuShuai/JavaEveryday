package graph;

import java.util.LinkedList;

public class UndirectedGraphNode
{

	int label;
	
	LinkedList<UndirectedGraphNode> neighbors;
	
	public UndirectedGraphNode(int i)
	{
		label = i;
		neighbors = new LinkedList<UndirectedGraphNode>();
	}
	
	/*  generates a graph like:            or if de-commenced 
	  1                                     	  1
     / \                                         / \
    /   \                                       /   \
   0     2                                     0 --- 2
        / \                                         / \
        \_/                                         \_/
	*/
	public static UndirectedGraphNode generate()
	{
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		
		n0.neighbors.add(n1);
		//n0.neighbors.add(n2);
		n1.neighbors.add(n0);
		n1.neighbors.add(n2);
		//n2.neighbors.add(n0);
		n2.neighbors.add(n1);
		n2.neighbors.add(n2);
		
		return n0;
	}
}
