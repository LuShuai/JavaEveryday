package string;
import java.util.ArrayList;

public class ZeroOneStar
{

	public static ArrayList<String> fill(String s)
	{
		ArrayList<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0)
			return res;
		getAllStrings(s, "", res);
		return res;
	}
	
	private static void getAllStrings(String s, String current, ArrayList<String> res)
	{
		if(s == null || s.length() == 0)
		{
			res.add(current);
			return;
		}
		if(s.charAt(0) == '*')
		{
			getAllStrings(s.substring(1), current + '0', res);
			getAllStrings(s.substring(1), current + '1', res);
		}
		else
		{
			getAllStrings(s.substring(1), s.charAt(0)+current, res);
		}
	}
	
	public static ArrayList<String> fill2(String s)
	{
		ArrayList<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0)
			return res;
		//numbwe of stars
		int num = 0;
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		for(int n = 0; n < s.length(); n++)
		{
			if(s.charAt(n) == '*')
			{
				positions.add(n);
				++num;
			}
		}
		int max = (int)Math.pow(2, num) - 1;
		while(max >= 0)
		{
			char[] ca = s.toCharArray();
			for(int n = 0; n < positions.size(); n++)
			{
				ca[positions.get(n)] =(char)((1 & (max >> n)) + '0');
			}
			res.add(new String(ca));
			--max;
		}
		return res;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		for(String s : fill2("1*"))
		{
			System.out.println(s);
		}
	}

}
