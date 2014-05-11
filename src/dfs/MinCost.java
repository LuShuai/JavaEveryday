package dfs;

public class MinCost{

	public static int getCost(int[][] map) {
		if (map == null || map.length == 0) {
			return 0;
		}
		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;
		search(map, 0, 0, 0, min);
		return min[0];
	}
	
	private static void search(int[][] map, int row, int col, int cCost, int[] min) {
		if (row == map.length - 1 && col == map.length - 1) {
			min[0] = (cCost < min[0] ? cCost : min[0]) + map[row][col];
		}
		if (row > map.length || col > map[0].length || cCost >= min[0]) {
			return;
		}
		int cost = map[row][col];
		map[row][col] = -1;
		// search top
		if (row > 0 && map[row - 1][col] >= 0) {
			search(map, row - 1, col, cCost + cost, min);
		}
		// search right
		if (col < map[0].length - 1 && map[row][col + 1] >= 0) {
			search(map, row, col + 1, cCost + cost, min);
		}
		// search bot
		if (row < map.length - 1 && map[row + 1][col] >= 0) {
			search(map, row + 1, col, cCost + cost, min);
		}
		// search left
		if (col > 0 && map[row][col - 1] >= 0) {
			search(map, row, col - 1, cCost + cost, min);
		}
		map[row][col] = cost;
	}
	

	public static void main(String[] args){
		// should be 7
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
		System.out.println(getCost(a));
		System.out.println(getCost(b));
		System.out.println(getCost(c));
	}
}
