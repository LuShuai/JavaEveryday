package someTest;
import hashmap.TwoKeySet;

/*
 * nd the smallest cost of traveling from (1,1) to (N,N). The cost of traveling to (i, j) is Cost[i, j].
0 <= Cost[i,j] <= 3
You can go 4 directions: ^, <, >, v

    1 2 3 
-----------
1 | 0 1 2
2 | 1 2 3
3 | 2 2 2

(1,1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)
         1      +  2      +  2      +  2
N=3 => 7


    0 1 2 3 4 
---------------
0 | 0 0 0 0 0
1 | 3 2 3 3 0
2 | 0 0 0 0 0
3 | 0 3 3 3 3
4 | 0 0 0 0 0


N=5 => 0


    1 2 3 4 5 6
-----------------
1 | 0 1 2 0 2 3
2 | 1 2 3 0 1 1
3 | 2 2 2 2 2 2
4 | 0 0 1 1 1 1
5 | 2 2 0 0 2 3
6 | 3 3 3 0 0 0
 */


public class ShortestPath
{	
	private static final boolean D = false;
	
	public int shortestPath(int[][] map)
	{
		if(map == null || map.length == 0 || map[0].length == 0)
			return -1;
		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;
		TwoKeySet<Integer, Integer> best = new TwoKeySet<Integer, Integer>();
		shortestPathHelper(map, 0, 0, 0, new TwoKeySet<Integer, Integer>(), min, best);
		//best.printAll();
		return min[0];
	}
	 
	private void shortestPathHelper(int[][] map, int row, int col, int cCost, TwoKeySet<Integer, Integer> path, int[] min, TwoKeySet<Integer, Integer> bestPath)
	{	
		if(row == map.length-1 && col == map.length-1)
		{
			if(D)
				System.out.println("==COST=== = " + cCost);
			//min[0] = cCost < min[0] ? cCost : min[0];
			if(cCost < min[0])
			{
				min[0] = cCost;
				bestPath = new TwoKeySet<Integer, Integer>(path);
				if(D)
					bestPath.printAll();
			}
			return;
		}
		//get rid of intersections
		if(path.contains(row, col) || row > map.length-1 || col > map.length-1 || row < 0 || col < 0)
		{
			if(D)
				System.out.println("row = " + row + "\tcol = " + col);
			return;
		}
		if(D)
		{
			System.out.println("checking node : " + row  + ", " + col);
		}
		
		TwoKeySet<Integer, Integer> pathSoFar = new TwoKeySet<Integer, Integer>(path);
		pathSoFar.add(row, col);
		//search bottom
		if(row < map.length-1)
		{
			shortestPathHelper(map, row+1, col, cCost + map[row][col], pathSoFar, min, bestPath);
		}
		//search top
		if(row > 0)
		{
			shortestPathHelper(map, row -1, col, cCost + map[row][col], pathSoFar, min, bestPath);
		}
		//search right
		if(col < map.length-1)
		{
			shortestPathHelper(map,row, col + 1, cCost + map[row][col], pathSoFar, min, bestPath);
		}
		//search left
		if(col > 0)
		{
			shortestPathHelper(map, row, col - 1, cCost + map[row][col], pathSoFar, min, bestPath);
		}
		//recover
		pathSoFar.remove(row, col);
	}	
	
	/**
	 * @param args
	 */

	public static void main(String[] args)
	{
		// should be 5
		int[][] a = {
				{0, 1, 2},
				{1, 2, 3},
				{2, 2, 2}
		};
		
		//should be 0
		int[][] b = {
				{0, 0, 0, 0, 0},
				{3, 2, 3, 3, 0},
				{0, 0, 0, 0, 0},
				{0, 3, 3, 3, 3},
				{0, 0, 0, 0, 0}
		};
		
		//should be 4
		int[][] c = {
				{0, 1, 2, 0, 2, 3},
				{1, 2, 3, 0, 1, 1},
				{2, 2, 2, 2, 2, 2},
				{0, 0, 1, 1, 1, 1},
				{2, 2, 0, 0, 2, 3},
				{3, 3, 3, 0, 0, 0}
			};
		
		ShortestPath sp = new ShortestPath();
		System.out.println("Shortest path in matrix a:" + sp.shortestPath(a)); //5
		System.out.println("Shortest path in matrix b:" + sp.shortestPath(b)); //0
		System.out.println("Shortest path in matrix c:" + sp.shortestPath(c)); //4
		
	}

}