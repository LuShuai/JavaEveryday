package basicAlg;

import java.util.ArrayList;

public class ALManipulate
{

	/**
	 * 		Test if I can directly modify items in ArrayList
	 */
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>(); 
		
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("D");
		
		for(int n = 0; n < al.size(); n++)
		{
			String s = al.get(n);
			al.set(n, "x" + s);
		}
		
		for(String s: al)
		{
			System.out.println(s);
		}
			
		

	}

}
