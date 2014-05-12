package arrays;

public class Q7
{

	/**
	 * Given an N*M array turn the rows and columns that contains 0 all into 0
	 */

	public static void turn20(int[][] a)
	{
		boolean Cols[] = new boolean[a[0].length];
		boolean Rows[] = new boolean[a.length];
		for(int n = 0; n< Cols.length; n++)
			Cols[n] = false;
		for(int n = 0; n< Rows.length; n++)
			Rows[n] = false;
		
		for(int col = 0; col < Cols.length; col++)
			for(int row = 0; row < Rows.length; row++)
			{
				if(a[row][col] == 0)
				{
					Cols[col] = true;
					Rows[row] = true;
				}
			}
		
		for(int n = 0; n < Rows.length; n++)
		{
			if(Rows[n])
				for(int m = 0; m< Cols.length; m++)
					a[n][m] = 0;
		}
		for(int n = 0; n < Cols.length; n++)
		{
			if(Cols[n])
				for(int m = 0; m< Rows.length; m++)
					a[m][n] = 0;
		}
		
	}
	
	
	public static void show(int[][] ca)
	{
		for(int n = 0; n < ca.length; n++)
		{
			for(int m = 0; m < ca[0].length; m++)
			{
				System.out.print(ca[n][m]);
			    System.out.print('\t');
			}
			System.out.print('\n');
		}
	}

	
	
	
	public static void main(String[] args)
	{
		int[][] array = {
				{1,2,3,4,5,6,7},
				{1,2,0,4,5,6,7},
				{0,3,4,5,0,7,8},
				{1,2,3,4,5,6,7}
		};
		show(array);
		System.out.println("-----------------------------------------------------------------");
		turn20(array);
		show(array);
	}

}
