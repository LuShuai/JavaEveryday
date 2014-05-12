package math;

public class Pow
{

	
	public static double pow(double x, int n) 
    {
        if(n == 0)
            return 1.0;
        if(n == 1)
            return x;
        
        if(n%2 == 0)
        {
            return pow(x, n/2) *  pow(x, n/2);
        }
        else
        {
            if(n>0)
            {
                return pow(x, n/2) * pow(x, n/2) * x;
            }
            else
            {
                return pow(x,n/2) * pow(x, n/2) /x;
            }
        }
        
    }
	
	
	
	
	public static double pow2(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		if (n == 1 || x == 1 || x == 0) {
			return x;
		}
		double half = pow2(x, n/2);
		if (n%2 == 0) {
			return  half * half;
		}
		else {
			if (n > 0) {
				return half * half * x;
			}
			else {
				return half * half / x;
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		System.out.println(""+pow(0.1,3));

	}

}
