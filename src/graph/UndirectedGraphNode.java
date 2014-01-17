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
}
