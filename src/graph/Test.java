package graph;

import graph.CopyGraph;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		
		n0.neighbors.add(n1);
		
		n1.neighbors.add(n0);
		n1.neighbors.add(n2);
		
		n2.neighbors.add(n1);
		n2.neighbors.add(n2);
		
		CopyGraph c = new CopyGraph();
		
		UndirectedGraphNode newStart = c.DFScopy(n0);
		
		for(UndirectedGraphNode m: newStart.neighbors.get(0).neighbors)
		{
			System.out.println(m.label);
		}

	}

}
