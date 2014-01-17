package someTest;

public class ReverseInt
{
	    public static int reverse(int x) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        String s = ""+x;
	        char[] ca = s.toCharArray();
	        int result = 0;
	        if(ca[0] == '-')
	        {
	            for(int n = ca.length-1; n > 0; n--)
	            {
	                result += Math.pow(10,n-1) * (ca[n]-48);
	            }
	            result = 0- result;
	        }
	        else
	        {
	            for(int n = 0; n < ca.length; n++)
	            {
	                result += Math.pow(10,n) * (ca[n]-48);
	            }
	        }
	        return result;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(""+reverse(-123));
	}

}
