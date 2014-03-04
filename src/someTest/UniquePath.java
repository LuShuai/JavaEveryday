package someTest;

public class UniquePath
{

	public static int uniquePaths(int m, int n) 
    {
        int[][] pn = new int[m][n];
        for(int r = 0; r < pn.length; r++)
            for(int c = 0; c < pn[0].length; c++)
                if( r == 0 || c == 0 )
                    pn[r][c] = 1;
                else
                    pn[r][c] = Integer.MIN_VALUE;
        
        if(m<=n)
        {
            //m -- 
        	print(pn);
            return uniquePathsm(m,n,pn);
            
        }
        else
        {
            //n --
        	print(pn);
            return uniquePathsn(m,n,pn);
        }
    }
    
    public static int uniquePathsm(int m, int n, int pn[][])
    {
        if(pn[m-1][n-1] != Integer.MIN_VALUE)
            return pn[m-1][n-1];
        
        int res = 0;
        for(int i = 1; i <= m; i++)
            res += uniquePathsm(i, n-1, pn);
        pn[m-1][n-1] = res;
        return res;
    }
    
    public static int uniquePathsn(int m, int n, int pn[][])
    {
        if(pn[m-1][n-1] != Integer.MIN_VALUE)
            return pn[m-1][n-1];
        
        int res = 0;
        for(int i = 1; i <= n; i++)
            res += uniquePathsn(m-1, i, pn);
        pn[m-1][n-1] = res;
        return res;
    }

    public static void print(int a[][])
    {
    	for(int m  = 0; m<a.length; m++)
    	{
    		for(int n = 0; n< a[0].length;n++)
    			System.out.print(a[m][n]);
    		System.out.println("");
    	}	
    }
	
	public static void main(String[] args)
	{
		System.out.println("\n" + uniquePaths(2,2));

	}

}
