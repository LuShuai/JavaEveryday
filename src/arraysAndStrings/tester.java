package arraysAndStrings;

public class tester
{

	/**
	 * @param args
	 */
	public static void print(char[][] ca)
	{
		for(int n=0; n < ca.length; n++)
		{
			for(int m=0; m < ca[0].length; m++ )
			{
				System.out.print(ca[n][m]+"\t");
			}
			System.out.print("\n");
		}
				
	}
	
	public static void main(String[] args)
	{
		
		String[] s = {"OXOOOOOOO","OOOXOOOOX","OXOXOOOOX","OOOOXOOOO","XOOOOOOOX","XXOOXOXOX","OOOXOOOOO","OOOXOOOOO","OOOOOXXOO"};
		char[][] ca = new char[s.length][s[0].length()];
		for(int n=0; n < ca.length; n++)
		{
			for(int m=0; m < ca[0].length; m++ )
			{
				ca[n][m] = s[n].charAt(m);
			}
		}
		
		print(ca);
		
		System.out.println("\n\n");
		
		XandO t = new XandO();
		t.solve(ca);
		print(ca);
		


	}

}
