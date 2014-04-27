package someTest;

import java.util.Iterator;

public class IteratorTest
{
	private int[] a;
	myIterater it;
	
	public IteratorTest()
	{
		a = new int[5];
		for(int n = 0; n < a.length; n++)
			a[n] = n;
		it = new myIterater();
	}
	
	
	public class myIterater implements Iterator<Integer>
	{
		int position;
		
		public myIterater()
		{
			position = 0;
		}
		
		@Override
		public boolean hasNext()
		{
			return position < a.length;
		}

		@Override
		public Integer next()
		{
			int res = a[position];
			++position;
			return res;
		}

		@Override
		public void remove()
		{
			int[] temp = new int[a.length - 1];
			int p = 0;
			for(int n = 0; n < a.length; n++)
			{
				if(n != position)
				{
					temp[p++] = n;
				}
			}
			a = temp;
		}
		
	}
	
	public static void main(String[] args)
	{
		IteratorTest test = new IteratorTest();
		myIterater it =  test.new myIterater();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
