package someTest;

import java.util.Stack;

public class LargestRectangleInHis
{

	public static int largestRectangleArea(int[] height) 
    {
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> s = new Stack<Integer>();
        
        int runner = 0;
        int max = 0;
        int high = 0;
        int wid = 0;
        int area = 0;
        while( runner < height.length ) 
        {
            if(s.isEmpty() || height[runner] >= height[s.peek()])
            {
                s.push(runner++);
            }
            else
            {
                high = height[s.pop()];
                wid = s.isEmpty() ? runner : runner - s.peek() - 1;
                area = high * wid;
                max = Math.max(area, max);
            }
            
        }
        while(!s.isEmpty())
        {
            high = height[s.pop()];
            wid = s.isEmpty() ? runner : runner - s.peek() - 1;
            System.out.println("high = " + high);
            System.out.println("wid = " + wid);
            area = high * wid;
            max = Math.max(area, max);
        }
        
        return max;
    }
	
	public static void main(String[] args)
	{
		int a[] = {4,2};
		System.out.println(largestRectangleArea(a));

	}

}
