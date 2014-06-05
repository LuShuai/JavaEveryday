package dfs;

/*
 * Suppose you got a map, where 1 is land 0 is water.
 * get the number of islands
 *   
 */


public class IslandNumber
{
	public static int getNumber(int[][] map) {
		if(map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int counter = 0;
		for (int m = 0; m < map.length; m++) {
			for (int n = 0; n < map[0].length; n++) {
				//found a piece of land
				if (map[m][n] == 1) {
					++counter;
					fill(map, m, n);
				}
			}
		}
		return counter;
	}
	
	private static void fill(int[][] map, int row, int col) {
		if(map == null || map.length == 0 || map[0].length == 0) {
			return;
		}
		if (row > map.length || col > map[0].length || map[row][col] != 1) {
			return;
		}
		map[row][col] = 2;
		//search top
		if (row > 0 && map[row - 1][col] == 1) {
			fill(map, row - 1, col);
		}
		//search right
		if (col < map[0].length - 1 && map[row][col + 1] == 1) {
			fill(map, row, col + 1);
		}
		//search bottom
		if (row < map.length - 1 && map[row + 1][col] == 1) {
			fill(map, row + 1, col);
		}
		//search left
		if (col > 0 && map[row][col - 1] == 1) {
			fill(map, row, col - 1);
		}
	}
	
	public static void main(String[] args)
	{
		int[][] map1 = {
				{1, 0, 1},
				{1, 1, 0}	
		};
		
		int[][] map2 = {
				{1, 1}
		};
		
		int[][] map3 = {
				{1, 0, 1},
				{0, 1, 0},
				{1, 0, 1}
				
		};
		
		int[][] map4 = {
				{1, 0, 1},
				{0, 1, 0},
				{1, 1, 1}
				
		}; 
		
		System.out.println(getNumber(map1)); // should be 2 
		System.out.println(getNumber(map2)); // should be 1 
		System.out.println(getNumber(map3)); // should be 5
		System.out.println(getNumber(map4)); // should be 3
	}

}
