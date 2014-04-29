package someTest;

import java.util.HashSet;

public class ShortestPath
{
	public class node
	{
		int x;
		int y;
		public node(int a, int b)
		{
			x = a;
			y = b;
		}
	}

	
	 public int shortestPath(int[][] map)
	 {
		if(map == null || map.length == 0 || map[0].length == 0)
			return -1;
		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;
		shortestPathHelper(map, new node(0,0), 0, new HashSet<node>(), min);
		return min[0];
	 }
	 
	 private void shortestPathHelper(int[][] map, node cNode, int cCost, HashSet<node> path, int[] min)
	 {
		 System.out.println("checking node : " + cNode.x  + ", " + cNode.y);
		 if(cNode.x == map.length && cNode.y == map.length)
		 {
			 min[0] = cCost < min[0] ? cCost : min[0];
			 return;
		 }
		 //get rid of intersections
		 if(path.contains(cNode))
		 {
			 return;
		 }
		 HashSet<node> pathSoFar = new HashSet<node>(path);
		 pathSoFar.add(cNode);
		 //search right
		 if(cNode.x < map.length-1)
		 {
			 shortestPathHelper(map, new node(cNode.x + 1, cNode.y), cCost + map[cNode.x][cNode.y], pathSoFar, min);
		 }
		 //search left
		 if(cNode.x > 0)
		 {
			 shortestPathHelper(map, new node(cNode.x -1, cNode.y), cCost + map[cNode.x][cNode.y], pathSoFar, min);
		 }
		 //search bottom
		 if(cNode.y < map.length-1)
		 {
			 shortestPathHelper(map, new node(cNode.x, cNode.y + 1), cCost + map[cNode.x][cNode.y], pathSoFar, min);
		 }
		 //search top
		 if(cNode.y > 0)
		 {
			 shortestPathHelper(map, new node(cNode.x, cNode.y-1), cCost + map[cNode.x][cNode.y], pathSoFar, min);
		 }
	 }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		/*
		int[][] a = {
				{0, 1, 2},
				{1, 2, 3},
				{2, 2, 2}
		};
		ShortestPath sp = new ShortestPath();
		System.out.println(sp.shortestPath(a));
		*/
	}

}
