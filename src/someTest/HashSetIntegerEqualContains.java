package someTest;

import java.util.HashSet;

public class HashSetIntegerEqualContains
{

	public static void main(String[] args)
	{
		HashSet<Integer> hash = new HashSet<Integer>();
		Integer a = 1;
		Integer b = 2;
		Integer c = 1;
		
		hash.add(a);
		System.out.println(hash.contains(b));
		System.out.println(hash.contains(c));

	}
}
