package someTest;

import java.util.ArrayList;

public class ValidIP
{

	public static ArrayList<String> restoreIpAddresses(String s) 
    {
        ArrayList<String> res = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12)
            return res;
        addIpAddresses(new String(), s, 1, res);
        return res;
    }
    
    public static void addIpAddresses(String left, String right, int position, ArrayList<String> res) 
    {
    	//System.out.println("position: "+position);
    	//System.out.println("left: "+left);
    	//System.out.println("right: "+right);
    	
        if(right == null || right.length() == 0 )
            return ;
        if(position == 4)
        {
        	if(isValide(right))
        	{
        		res.add(left + right);
        		return;
        	}
        	else
        		return;
        }
        for(int n = 1; n<=3; n++)
        {
            if(n <= right.length() && isValide(right.substring(0,n)))
            {
                addIpAddresses(left + right.substring(0,n)+'.', right.substring(n), position+1, res);
            }
        }
    }

    private static boolean isValide(String s)
    {
        if(s == null || s.length()< 0 || s.length() > 3)
            return false;
        if(s.charAt(0) == '0')
            return s.equals("0");
        int val = Integer.parseInt(s);
        if(val<=255 && val >=0)
            return true;
        else
            return false;
    }
    
	public static void main(String[] args)
	{
		ArrayList<String> a = restoreIpAddresses("010010");
		for(String s : a)
			System.out.println(s);

	}

}
