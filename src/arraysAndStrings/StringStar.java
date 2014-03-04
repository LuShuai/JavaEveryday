package arraysAndStrings;
import java.util.LinkedList;

public class StringStar
{
	public static LinkedList<String> substitute(String s)
	{
		LinkedList<String> res = new LinkedList<String>();
		generate("",s,res);
		return res; 
	}
	
	private static void generate(String left, String right, LinkedList<String> res)
	{
		//System.out.println("right: " + right);
		if(right.length() == 0)
		{
			res.add(left);
			return;
		}
		if(right.charAt(0) == '*')
		{
			generate(left+'0',right.substring(1,right.length()), res);
			generate(left+'1',right.substring(1,right.length()), res);
			return;
		}
		else
		{
			int runner = 1;
			while(runner < right.length() && right.charAt(runner) != '*')
			{
				++runner;
			}
			//System.out.println("left + :" + left + right.substring(0,runner));
			generate(left + right.substring(0,runner),right.substring(runner,right.length()), res);
			return;
		}
	}
	
	public static void main(String[] args)
	{
		LinkedList<String> l = substitute("***");
		for(String s : l)
			System.out.println(s);
	}

}
