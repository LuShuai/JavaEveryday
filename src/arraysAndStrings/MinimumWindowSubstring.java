package arraysAndStrings;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
import java.util.HashMap;

public class MinimumWindowSubstring
{
	public static String minWindow(String S, String T) 
    {
        if(S == null || T == null || S.length() == 0 || T.length() ==0 || S.length() < T.length())
            return "";
            
        HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        //init the 2 maps
        for(int n = 0; n < T.length(); n++)
        {
            hasFound.put(T.charAt(n), 0);
            if(!needToFind.containsKey(T.charAt(n)))
            {
                needToFind.put(T.charAt(n), 1);
            }
            else
            {
                needToFind.put(T.charAt(n), needToFind.get(T.charAt(n)) + 1);
            }
        }
        
        int min = Integer.MAX_VALUE;
        int minStart = -1;
        int start = 0;
        int end = 0;
        int len = 0;
        //for(Character c : needToFind.keySet())
        //	System.out.println(c);
        while(end < S.length())
        {
            if(needToFind.containsKey(S.charAt(end)))
            {
                if(hasFound.get(S.charAt(end)) < needToFind.get(S.charAt(end)))
                    ++len;
                hasFound.put(S.charAt(end), hasFound.get(S.charAt(end)) + 1 );
                
                //found all what we need!
                if(len == T.length())
                {
                    //find the best start position
                    while(!needToFind.containsKey(S.charAt(start)) || hasFound.get(S.charAt(start)) > needToFind.get(S.charAt(start)))
                    {
                        if(needToFind.containsKey(S.charAt(start)))
                        {
                            hasFound.put(S.charAt(start), hasFound.get(S.charAt(start)) - 1);
                        }
                        ++start;
                    }
                    
                    //save the current min window substring
                    if(end - start + 1 < min)
                    {
                        min = end - start + 1;
                        minStart = start;
                    }
                }
            }
            ++end;
        }
        System.out.println("minstart :" + minStart);
        System.out.println("minLen :" + min);
        if(minStart == -1)
            return "";
        
        return S.substring(minStart, minStart + min);
        
    }
	
	public static void main(String[] args)
	{
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}

}
