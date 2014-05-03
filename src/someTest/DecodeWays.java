package someTest;
/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */


public class DecodeWays
{

	public static int numDecodings(String s) 
    {
        if(s == null || s.length() == 0)
            return 0;
        int[] mem = new int[s.length()];
        for(int n = 0; n < mem.length; n++)
        	mem[n] = -1;
        return numDecodings(s, s.length() - 1, mem);
    }
    
    private static int numDecodings(String s, int position, int[] mem)
    {
        //validation
        if(position >= s.length() || position < 0 || !isValid(s.charAt(position)))
        {
            return -1;
        }
        //dp case
        if(mem[position] != -1)
            return mem[position];
        //base case
        if(position == 0)
        {
        	if(s.charAt(position) == '0')
        		mem[0] = 0;
        	else
        		mem[0] = 1;
            return mem[0];
        }
        if(position == 1)
        {
        	if(s.charAt(position) == '0')
        	{
        		if(s.charAt(0) == '1' || s.charAt(0) == '2')
        		{
        			mem[1] = 1;
        		}
        		else
        		{
        			mem[1] = 0;
        		}
        	}
        	else if(s.charAt(position - 1) == '0')
        	{
        		mem[1] = 0;
        	}
        	else if(s.charAt(position - 1) == '1' || (s.charAt(position) <= '6' && s.charAt(position - 1) == '2') )
            {
                mem[1] = 2;
            }
            else
            {
                mem[1] = 1;
            }
        	return mem[1];
        }
        //recursion case
        if(s.charAt(position) == '0')
        {
        	if(s.charAt(position - 1) == '1' || s.charAt(position - 1) == '2')
        		mem[position] = numDecodings(s, position - 2, mem);
        	else
        		mem[position] = 0;
        }
        else if(s.charAt(position - 1) == '1' || (s.charAt(position) <= '6' && s.charAt(position - 1) == '2') )
        {
        	mem[position] = numDecodings(s, position - 1, mem) + numDecodings(s, position - 2, mem);
        }
        else
        {
            mem[position] = numDecodings(s, position -1, mem);
        }
        return mem[position];
    }
    
    private static boolean isValid(char c)
    {
        return c <= '9' && c >= '0';
    }
	
	
	public static void main(String[] args)
	{
		String s = "26";
		System.out.println(numDecodings(s));

	}

}
