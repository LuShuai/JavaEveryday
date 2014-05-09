package arraysAndStrings;
import java.util.HashSet;

public class EquivalentStrings
{
	public static boolean allStringSetsIdentical(String[ ][ ] sets)
	{
		if(sets == null || sets.length == 0 || sets[0].length == 0)
		{
				return true;
		}
		//the equivalent pattern
		HashSet<String> pattern = new HashSet<String>();
		for(int n = 0; n < sets[0].length; n++)
		{
			if(sets[0][n] != null || sets[0][n].length() != 0)
				pattern.add(sets[0][n]);
		}
		HashSet<String> got = new HashSet<String>();
		HashSet<String> tempPattern = new HashSet<String>(pattern);
		//test the rest part of the sets
		for(int m = 1; m < sets.length; m++)
		{
			for(int n = 0; n < sets[m].length; n++)
			{
				if(sets[m][n] != null || sets[m][n].length() != 0)
				{
					if(tempPattern.contains(sets[m][n]))
					{
						tempPattern.remove(sets[m][n]);
						got.add(sets[m][n]);
					}
					else if(!got.contains(sets[m][n]))
					{
						return false;
					}
					else
					{
						continue;
					}
				}
			}
			if(!tempPattern.isEmpty())
				return false;
			//re-initialize temp-pattern and got set  
			tempPattern = new HashSet<String>(pattern);
			got = new HashSet<String>();
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}}));  // return true;
		System.out.println(allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}}));  //return false;
	}
}
