package arraysAndStrings;

public class InterleavingStrings
{
	
	public static boolean isInterleave(String s1, String s2, String s3) 
    {
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        if(s1.length() == 0)
            return s2.equals(s3);
        if(s2.length() == 0)
            return s1.equals(s3);
        if(s3.length() - s1.length() != s2.length())
            return false;
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int n = 0; n < memo.length; n++)
            for(int m = 0; m < memo[0].length; m++)
                memo[n][m] = -1;
        return isInterleaveHelper(s1,0,s2,0,s3,0,memo);
    }
    
    private static boolean isInterleaveHelper(String s1, int start1, String s2, int start2, String s3, int start3, int[][] memo)
    {
    	System.out.println("start1:" + start1);
    	System.out.println("start2:" + start2);
    	System.out.println("start3:" + start3);
        if(start1 == s1.length() && start2 == s2.length() && start3 == s3.length())
        {
            return true;
        }
        
        if(memo[start1][start2] != -1)
        {
        	System.out.println("memo");
            if(memo[start1][start2] == 1)
                return true;
            else
                return false;
        }
            
        if( (s3.length() - start3) - (s1.length() - start1) != (s2.length() - start2))
        {
        	System.out.println("nor same length");
            memo[start1][start2] = 0;
            return false;
        }

        if( ( start1 < s1.length() &&  s1.charAt(start1) == s3.charAt(start3) && isInterleaveHelper(s1, start1+1,s2,start2,s3, start3+1, memo)) ||
        (start2 < s2.length() && s2.charAt(start2) == s3.charAt(start3) && isInterleaveHelper(s1, start1,s2,start2+1,s3, start3+1, memo)))
        {
            memo[start1][start2] = 1;
        }
        else
        {
            memo[start1][start2] = 0;
        }
        return memo[start1][start2] == 1;
    }

	
	public static void main(String[] args)
	{
		System.out.println(isInterleave("a","b", "ab"));

	}

}
