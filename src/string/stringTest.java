package string;

public class stringTest
{
	
	static String s1 = "Hello";              // String literal
	static String s2 = "Hello";              // String literal
	static String s3 = s1;                   // same reference
	static String s4 = new String("Hello");  // String object
	static String s5 = new String("Hello");  // String object
	
	
	
	private static void show(Boolean b)
	{
		if(b)
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
	}
	
	public static void main(String[] args)
	{
		show(s1 == s1);         // true, same pointer
		show(s1 == s2);         // true, s1 and s2 share storage in common pool
		show(s1 == s3);         // true, s3 is assigned same pointer as s1
		show(s1.equals(s3));    // true, same contents
		show(s1 == s4);         // false, different pointers
		show(s1.equals(s4));    // true, same contents
		show(s4 == s5);         // false, different pointers in heap
		show(s4.equals(s5));    //true same content
		
		String x = "s1";
		System.out.println(x.hashCode());
		String y = x;
		System.out.println(y.hashCode());
		System.out.println(x.hashCode());
		System.out.println(y.hashCode());
		System.out.println("x:"+x+";   y:"+y);
		show(y==x);
	}
}
