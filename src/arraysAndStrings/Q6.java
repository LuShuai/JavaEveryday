package arraysAndStrings;

/* 
 * Rotate a N*N matrix by 90°
 * 
 *  Shuai Lu
 *  Sep. 22
 */



public class Q6
{
	
	public static void show(char[][] ca)
	{
		int l = ca.length;
		for(int n = 0; n < l; n++)
		{
			for(int m = 0; m < l; m++)
			{
				System.out.print(ca[n][m]);
			    System.out.print('\t');
			}
			System.out.print('\n');
		}
	}
	

	public static void rotate(char[][] ca)
	{
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		char[][] c = { 	{'a', 'b', 'c'},
						{'d', 'e', 'f'},
						{'g', 'h', 'i'}
		};
		
		show(c);
		
	}

}
