package arraysAndStrings;

import java.util.ArrayList;

public class TextJustification
{
	
	public static ArrayList<String> fullJustify(String[] words, int L) 
    {
        ArrayList<String> res = new ArrayList<String>();
        
        if(words == null || words.length == 0)
            return res;
        
        int word_length = 0;
        int word_num = 0;
        int start = 0;
        //int end = 0;
        
        for(int n = 0; n < words.length; n++ )
        {
            word_num ++;
            word_length += words[n].length();
            
            if(n == words.length - 1)
            {
            	if(word_length + word_num - 1 <= L)
            	{
            		StringBuilder sb = new StringBuilder();
            		sb.append(words[start]);
            		for(int m = start + 1; m <= n; m++)
            		{
            			sb.append("-");
            			sb.append(words[m]);
            		}
            		int current_len = sb.length();
            		for(int m = 0; m < L - current_len; m++)
            		{
            			sb.append("-");
            		}
            		res.add(new String(sb));
            	}
            	else
            	{
            		res.add(arrangeWords(words, start, n-1, L));
            		res.add(arrangeWords(words, n, n, L));
            	}
            	break;
            }
            
            
            if(word_length + word_num - 1 == L)
            {
            	res.add(arrangeWords(words, start, n, L));
            	word_num = 0;
            	word_length = 0;
            	start = n + 1;
            }
            else if( word_length + word_num - 1 > L)
            {
            	res.add(arrangeWords(words, start, n-1, L));
            	word_num = 1;
            	word_length = words[n].length();
            	start = n;
            }
            /*
            System.out.println("\t word_num = " + word_num);
            System.out.println("\t word_length = " + word_length);
            if(word_length + word_num - 1 < L)
            {
            	end = n;
            }
            else if(word_length + word_num - 1 == L)
            {
            	System.out.println("**" + end);
            	res.add(arrangeWords(words, start, end, L));
            	start = n + 1;
            	end = start;
            	word_length = 0;
            	word_num = 0;
            }
            else
            {
                res.add(arrangeWords(words, start, end, L));
                start = n;
                end = n;
                word_length = words[n].length();
                word_num = 1;
                continue;
            }
            
            if(n == words.length - 1 && start < words.length)
            {
                
            }
            */
        }
        return res;
    }
    //arrange serveral words into a long string with proper length and number of spaces
    private static String arrangeWords(String[] words, int start, int end, int L)
    {
    	System.out.println("start" + start);
    	System.out.println("end" + end);
        StringBuilder res = new StringBuilder();
        //TODO: 
        if(start == end)
        {
            res.append(words[start]);
            for(int i = 0; i < L-words[start].length(); i++)
                res.append("-");
            return new String(res);
        }
        if(end < start)
            return new String();
        int num = end - start;   //the number of spaces should be length - 1;
        int words_length = 0;
        int base_space_length = 0;
        int offset_space_length = 0;
        for(int n = start; n <= end; n++)
            words_length += words[n].length();
        base_space_length = (L-words_length)/num;
        offset_space_length = (L-words_length)%num;
        
        res.append(words[start]);
        for(int n = start + 1; n <= end; n++)
        {
            for(int i = 0; i < base_space_length; i++)
                res.append("-");
            if(offset_space_length > 0)
            {
                res.append("-");
                --offset_space_length;
            }
            res.append(words[n]);
        }
        return new String(res);
    }
	
	public static void main(String[] args)
	{
		//String[] sa = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] sa = {"Listen","to","many,","speak","to","a","few."};
		print(fullJustify(sa, 6));

	}
	
	public static void print(ArrayList<String> as)
	{
		for(String s : as)
			System.out.println("[" + s + "]");
	}

}
