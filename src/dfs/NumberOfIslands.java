package dfs;

public class NumberOfIslands {
	/*
		calculate the number of islands in a 2D array.
		Suppose : 0 is water,  1 is land. 
	*/
	
	public static int getNumber(int[][] map) {
		if(map == null || map.length == 0 || map[0].length == 0)
			return 0;
		int num = 0;
		for (int m = 0; m < map.length; m++) {
			for (int n = 0; n < map[0].length; n++) {
				if (map[m][n] == 1) {
					++num;
					fillLand(map, m, n);
				}
			}
		}
		for (int m = 0; m < map.length; m++) {
			for (int n = 0; n < map[0].length; n++) {
				if (map[m][n] == 3) {
					map[m][n] = 1;
				}
			}
		}
		return num;
	}
	
	private static void fillLand(int[][] map, int row, int col){
		if (row > map.length || col > map[0].length || map[row][col] != 1) {
			return;
		}
		map[row][col] = 3;
		//search top
		if (row > 0 && map[row - 1][col] == 1) {
			fillLand(map, row - 1, col);
		}
		//search right
		if (col < map[0].length - 1 && map[row][col + 1] == 1) {
			fillLand(map, row, col + 1);
		}
		//search bot
		if (row < map.length - 1 && map[row + 1][col] == 1) {
			fillLand(map, row + 1, col);
		}
		//search left
		if (col > 0 && map[row][col - 1] == 1) {
			fillLand(map, row, col - 1);
		}
	}
	
	
	public static void main(String[] args) {
		int[][] map1 = {
				{0}
				
		};   //should return 0
		
		int[][] map2 = {
				{1}
				
		};  //should return 1
		
		int[][] map3 = {
				{1,0,1},
				{0,1,0},
				{1,0,1}
		}; //should return 5
		
		int[][] map4 = {
				{1,1,1,0},
				{1,0,0,0},
				{0,1,1,0},
				{1,0,0,1}
		};   //should return 4

		System.out.println(getNumber(map1));
		System.out.println(getNumber(map2));
		System.out.println(getNumber(map3));
		System.out.println(getNumber(map4));
	}
}
