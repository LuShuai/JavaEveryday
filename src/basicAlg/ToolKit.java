package basicAlg;

public class ToolKit
{

	public static void swap(int[] a, int x, int y)
	{
		a[x] = a[x]^a[y];
		a[y] = a[x]^a[y];
		a[x] = a[x]^a[y];
	}
	public static void swap(char[] a, int x, int y)
	{
		char temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
