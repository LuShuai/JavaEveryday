package arraysAndStrings;

public class isPalindrome
{

	public static boolean isP(String s) 
    {
        if(s == null || s.length() == 0)
            return true;
        int left = 0;
        int right = s.length()-1;
        
        while(right > left)
        {
            //find the left most char
            while(left < s.length() && !isAlpha(s.charAt(left)))
            {
                left ++;
            }
            //find the right most char
            while(right > 0 && !isAlpha(s.charAt(right)))
            {
                right --;
            }
            //if(s.charAt(left) != s.charAt(right) && s.charAt(left) != s.charAt(right)+('A'-'a') && s.charAt(left)+('A'-'a') != s.charAt(right))
            if(left>=s.length() || right <0 )
            	return true;
            if( Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right)))
                return false;
            ++left;
            --right;
        }
        return true;
        
    }
    
    private static boolean isAlpha(char c)
    {
        if( (c<='Z' && c>='A' ) || (c<='z' && c>='a'))
            return true;
        else
            return false;
    }
	
	public static void main(String[] args)
	{
		System.out.println(""+isP("1a2"));
		//System.out.println(""+isAlpha('a'));

	}

}
