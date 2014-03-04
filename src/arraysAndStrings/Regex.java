package arraysAndStrings;

public class Regex
{

	public static boolean isMatch(String str, String regex)
	{
		System.out.println("string:" + str);
		System.out.println("regex:" + regex);
		//regex.length == 0
		if(regex == null || regex.length() == 0) 
			return str == null || str.length() == 0;
		//regex.length == 1
		if(regex.length() == 1)
			return (regex.charAt(0) == '.' && (str.length() != 0)) || ( (regex.charAt(0) == str.charAt(0) && str.length() == 1));
		//regex.length >= 2
		if(regex.charAt(1)!='*')
		{
			if(str.length() <=1 )
				return false;
			return ( (regex.charAt(0) == str.charAt(0) || (regex.charAt(0) == '.' && str !=null ) ) 
					 && isMatch(str.substring( 1,str.length() ), regex.substring(1,regex.length()) ) 
				   );
		}
		else
		{
			int i = 0;
			while(  i < str.length() &&  (str.charAt(i) == regex.charAt(0) || ( regex.charAt(0) == '.' && (i == 0 || str.charAt(i) == str.charAt(i-1))) ) )
			{
				i++;
			}
			//now i is the next one who is not matched with *
			return isMatch(str.substring(i,str.length()), regex.substring(2,regex.length()));
		}
	}

	
	public static void main(String[] args)
	{
		System.out.println(isMatch("aaa","a*"));

	}

}
