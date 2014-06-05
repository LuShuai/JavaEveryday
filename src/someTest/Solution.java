package someTest;

import java.util.Stack;

public class Solution 
{
	
	public static int evalRPN(String[] tokens) 
    {
        if(tokens.length == 0)
            return 0;
        if(tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        
        Stack<Integer> numbers = new Stack<Integer>();
        int result = 0;
        int tmp;
        for(int n = 0; n < tokens.length; n++)
        {
            if(!isOperator(tokens[n]))
            {
                numbers.push(Integer.parseInt(tokens[n]));
            }
            else
            {
                if(numbers.size()<2)
                    return Integer.MIN_VALUE;
                if(tokens[n] == "+")
                {
                    tmp = numbers.pop();
                    result = numbers.pop() + tmp;
                }
                else if(tokens[n] == "+")
                {
                    tmp = numbers.pop();
                    result = numbers.pop() - tmp;
                }
                else if(tokens[n] == "*")
                {
                    tmp = numbers.pop();
                    result = numbers.pop() * tmp;
                }
                else if(tokens[n] == "/")
                {
                    tmp = numbers.pop();
                    result = numbers.pop() / tmp;
                }
                else
                {
                    return Integer.MIN_VALUE;
                }
                numbers.push(result);
            }
            
        }
        return numbers.pop();
    }
    
    private static boolean isOperator(String s)
    {
        return s == "+" || s == "-" || s == "*" || s == "/";
    }
	
    public static int removeElement(int[] A, int elem) 
    {
        if(A == null || A.length == 0)
            return 0;

        int newLength = A.length;
        int right_counter = newLength - 1;
        int left_counter = 0;
        
        while(right_counter > left_counter)
        {
            //find the right most element that is not elem.
            //if is elem, the new length--
            while(A[right_counter] == elem && right_counter>0)
            {
                --right_counter;
                --newLength;
            }
            //find the left most elem in A
            while(A[left_counter] != elem && left_counter<newLength-1)
            {
                ++left_counter;
            }
            if(left_counter < right_counter)
            {
                swap(A, left_counter, right_counter);
                ++left_counter;
                --right_counter;
                --newLength;
            }
        }
        if(A[right_counter] == elem && right_counter == left_counter)
        {
            A = null;
            --newLength;
        }
        return newLength;
    }
    
    private static void swap(int[] A, int a, int b)
    {
    	System.out.println("a "+A[a]);
    	System.out.println("b "+A[b]);
        A[a] = a^b;
        A[b] = a^b;
        A[a] = a^b;
    }
    
    public static void main(String[] args)
    {
    	String[] ss = {"4", "13", "5", "/", "+"};
    	System.out.println(evalRPN(ss));
    }
}
