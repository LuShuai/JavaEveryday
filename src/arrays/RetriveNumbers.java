package arrays;

public class RetriveNumbers
{

	public static int getTime(String str, String pat)
	{
		int i = 0; 
		int j = 0; 
		int i_rev = 0; 
		int j_rev = 0; 
		int number_of_occurence = 0;
		char[] string_array = str.toCharArray();
		char[] patten_array = pat.toCharArray();
		while(i<string_array.length && j <patten_array.length) 
		{ 
			if (string_array[i] == patten_array[j]) 
			{ 
				i++; 
				j++; 
				if (j == patten_array.length) 
					number_of_occurence++; 
			} 
			else 
			{ 
				i = i - j + 1;
				j = 0;
			} 
			if(string_array[i_rev] == patten_array[j_rev]) 
			{ 
				i_rev++; 
				j_rev++; 
				if (j_rev == patten_array.length) 
					number_of_occurence++; 
			} 
			else 
			{ 
				i_rev = i_rev - j_rev + 1;
				j_rev = 0;
			} 
		} 

		return number_of_occurence;
	}
	
	
	
	
	public static void main(String[] args)
	{
		System.out.println(""+getTime("abcdcba","abc"));

	}

}
