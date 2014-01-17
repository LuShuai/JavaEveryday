/*

package someTest;
import graph.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class CopyAGraph
{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return BFScloneGraphHelper(node, visited);
    }
    
    private UndirectedGraphNode DFScloneGraphHelper(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> visited)
    {
        if(node == null)
            return null;
        if(visited.containsKey(node))
            return visited.get(node);
        UndirectedGraphNode copier = new UndirectedGraphNode(node.label);
        visited.put(node,copier);
        for(UndirectedGraphNode m: node.neighbors)
        {
            copier.neighbors.add(DFScloneGraphHelper(m, visited));
        }
        return copier;
    }
    
    private UndirectedGraphNode BFScloneGraphHelper(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> visited)
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
            System.out.println("parent:"+parent.label);
            for(UndirectedGraphNode n : parent.neighbors)
            {
            	
                if(!visited.containsKey(n))
                {
                	System.out.println("n(no exist):"+n.label);
                    UndirectedGraphNode new_node = new UndirectedGraphNode(n.label);
                    visited.get(parent).neighbors.add(new_node);
                    visited.put(n, new_node);
                    queue.add(n);
                }
                else
                {
                	System.out.println("n(exist):"+n.label);
                    visited.get(parent).neighbors.add(visited.get(n));
                }
            }
        }
        return copier;
        
    }
}
*/