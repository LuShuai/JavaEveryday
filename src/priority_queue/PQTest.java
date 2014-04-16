package priority_queue;

import java.util.PriorityQueue;
import java.util.Comparator;


public class PQTest
{
	
	
	
	public static void main(String[] args)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(2, 
				new Comparator<Integer>(){
					public int compare(Integer I1, Integer I2)
					{
						return I1 < I2 ? 1 : (I1 > I2 ? -1 : 0);
					}
			}
		);
		
		pq.add(2);
		pq.add(3);
		pq.add(1);
		pq.add(5);
		pq.add(6);
		pq.add(7);
		
		while(!pq.isEmpty())
		{
			System.out.println(pq.poll());
		}
	}

}
