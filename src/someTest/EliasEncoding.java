package someTest;

public class EliasEncoding
{
	public static String getGamma(int k)
	{
		System.out.print("k = " + k + ":   ");
		int kd = (int) log2base(k);
		int kr = k - (int)Math.pow(2, kd);

		char[] c = new char[kd];
		for(int n = 0 ; n < kd; n++)
			c[n] = '1';
		String krBinary = Integer.toBinaryString(kr);
		char[] pad;
		if(kd>krBinary.length())
		{
			pad = new char[krBinary.length()];
			for(int n = 0; n < pad.length; n++)
				pad[n] = '0';
		}
		else
		{
			pad = new char[0];
		}
		
		return new String(c)+"0 " + new String(pad) + Integer.toBinaryString(kr);
	}
	
	public static String getTheta(int k)
	{
		System.out.print("k = " + k + ":   ");
		int kd = (int) log2base(k);
		int kr = k - (int)Math.pow(2, kd);
		System.out.println("kd = " + kd);
		
		
		
		int kdd = (int) log2base(kd+1);
		int kdr = kd+ 1 - (int)Math.pow(2,kdd); 
		
		
		
		char[] c = new char[kdd];
		for(int n = 0 ; n < kdd; n++)
			c[n] = '1';
		System.out.println("kdd = " + kdd);
		return new String(c)+"0 " + Integer.toBinaryString(kdr) + " " + Integer.toBinaryString(kr);
	}
	
	
	private static double log2base(int x)
	{
		double k = (double)x;
		return Math.log(k)/Math.log(2);
	}
	
	
	public static void main(String[] args)
	{
		
		System.out.println(getGamma(1));
		System.out.println(getGamma(2));
		System.out.println(getGamma(3));
		System.out.println(getGamma(4));
		System.out.println(getGamma(5));
		System.out.println(getGamma(8));
		System.out.println(getGamma(10));
		System.out.println(getGamma(14));
		System.out.println(getGamma(212));
		System.out.println(getGamma(1035));
		
		
		System.out.println(getTheta(1));
		System.out.println(getTheta(2));
		System.out.println(getTheta(3));
		System.out.println(getTheta(4));
		System.out.println(getTheta(5));
		System.out.println(getTheta(8));
		System.out.println(getTheta(10));
		System.out.println(getTheta(14));
		System.out.println(getTheta(212));
		System.out.println(getTheta(1035));
		
	}
	
}
