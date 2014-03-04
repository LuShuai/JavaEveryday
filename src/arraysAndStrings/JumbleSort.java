package arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;

public class JumbleSort
{

	public static void jumbleSort(String[] in)
	{
		if(in.length < 2)
				return;
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		//true for word, false for num
		boolean[] position = new boolean[in.length];
		for(int n = 0; n < in.length; n++)
		{
			if(isNumeric(in[n]))
			{
				nums.add(Integer.parseInt(in[n]));
				position[n] = false;
			}
			else
			{
				words.add(in[n]);
				position[n] = true;
			}
		}
		
		Collections.sort(words);
		Collections.sort(nums);
		int num_p = 0;
		int word_p = 0;
		
		for(int n = 0; n < position.length; n++)
		{
			
		}
		
		
		
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
