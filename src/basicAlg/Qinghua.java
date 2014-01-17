package basicAlg;

public class Qinghua
{
	
	private static int[] result = new int[20];
	private static void init()
	{
		for(int n=0; n<result.length; n++)
		{
			result[n] = -1;
		}
		result[0] = 20;
		result[1] = 1;
	}
	public static int get(int k)
	{
		if(result[k]!=-1)
			return result[k];
		else
		{
			result[k] = get(k-1) + 14*get(k-2);
			return result[k];
		}
	}
	
	public static void main(String[] args)
	{
		init();
		System.out.println(""+get(5));
	}
	

}
