package arrays;

public class ReverseSentence
{

	public static String reverseWords(String s) 
    {
        if(s == null || s.length() == 0)
            return s;
        StringBuilder res = new StringBuilder();
        char[] ca = s.toCharArray();
        reverse(ca, 0, ca.length-1);
        int left = 0;
        while(true)
        {
            while(left < ca.length && ca[left] == ' ')
            {
                ++left;
            }
            if(left >= ca.length)
            {
                if(res.length()>0)
                    res.deleteCharAt(0);
                return new String(res);
            }
            int right = left+1;
            while(right < ca.length && ca[right] != ' ')
            {
                ++right;
            }
            
            res.append(' ');
            for(int p = right-1; p>=left; p--)
            {
                res.append(ca[p]);
            }
            left = right+1;
        }
    }
    
    public static void reverse(char[] s, int left, int right)
    {
        if(s == null || s.length == 0 || s.length == 1)
        {
            return;
        }
        while(right > left)
        {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }
    }
    
	public static void main(String[] args)
	{
		System.out.println(reverseWords("   the    sky is blue  "));
		/*
		String s = "the sky is blue";
		char[] ca = s.toCharArray();
		reverse(ca, 0, ca.length-1);
		System.out.println(ca);
		*/
	}

}
