package graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class CopyGraph
{
	public static UndirectedGraphNode copy(UndirectedGraphNode start)
	{
		HashMap<UndirectedGraphNode,UndirectedGraphNode> created= new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		return BFScloneGraphHelper(start, created);
		
	}
	
	private static UndirectedGraphNode DFScloneGraphHelper(UndirectedGraphNode start, HashMap<UndirectedGraphNode,UndirectedGraphNode> created)
	{
		if(start == null)
			return null;
		if(created.containsKey(start))
			return created.get(start);
		UndirectedGraphNode newStart = new UndirectedGraphNode(start.label);
		created.put(start, newStart);
		for(UndirectedGraphNode m : start.neighbors)
		{
			newStart.neighbors.add(DFScloneGraphHelper(m, created));
		}
		return newStart;
	}
	
	private static UndirectedGraphNode BFScloneGraphHelper(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> visited)
    {
        if(node == null)
            return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        UndirectedGraphNode copier = new UndirectedGraphNode(node.label);
        queue.add(node);
        visited.put(node,copier);
        
        while(!queue.isEmpty())
        {
            UndirectedGraphNode parent = queue.remove();
            System.out.println("pop: " + parent.label);
            for(UndirectedGraphNode n : parent.neighbors)
            {
                if(!visited.containsKey(n))
                {
                	System.out.println("Does not contain key: " + n.label);
                    UndirectedGraphNode new_node = new UndirectedGraphNode(n.label);
                    visited.get(parent).neighbors.add(new_node);
                    visited.put(n, new_node);
                    queue.add(n);
                }
                else
                {
                	System.out.println("Contains key: " + n.label);
                    visited.get(parent).neighbors.add(visited.get(n));
                }
            }
        }
        return copier;
    }
	
	public static void main(String[] args)
	{
		UndirectedGraphNode node = UndirectedGraphNode.generate();
		UndirectedGraphNode copy = copy(node);
		
		/*
		 * System.out.println(copy.label);
		for(UndirectedGraphNode n : copy.neighbors)
		{
			System.out.println(n.label);
		}
		*/
		
		for(UndirectedGraphNode n : copy.neighbors.get(0).neighbors)
		{
			System.out.println(n.label);
		}
		
		System.out.println(copy.neighbors.get(0).neighbors.size());
		
		
	}
}




