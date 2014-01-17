package graph;
import java.util.HashMap;


public class CopyGraph
{
	public UndirectedGraphNode DFScopy(UndirectedGraphNode start)
	{
		HashMap<UndirectedGraphNode,UndirectedGraphNode> created= new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		return DFScopyHelper(start, created);
		
	}
	
	private UndirectedGraphNode DFScopyHelper(UndirectedGraphNode start, HashMap<UndirectedGraphNode,UndirectedGraphNode> created)
	{
		if(start == null)
			return null;
		if(created.containsKey(start))
			return created.get(start);
		
		UndirectedGraphNode newStart = new UndirectedGraphNode(start.label);
		created.put(start, newStart);
		for(UndirectedGraphNode m : start.neighbors)
		{
			newStart.neighbors.add(DFScopyHelper(m, created));
		}
		
		return newStart;
	}

}




