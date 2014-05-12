package string;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class WordLaderLength {
    public static int ladderLength(String start, String end, HashSet<String> dict) 
    {
        int result = 0;
        if(start.length() != end.length() || start.length() == 0 || dict == null)
            return result;
        
        dict.add(start);
        dict.add(end);
        
        //cal the path length
        Queue<String> words = new LinkedList<String>();
        Queue<Integer> length = new LinkedList<Integer>();
        
        words.add(start);
        length.add(1);
        
        while(!words.isEmpty())
        {
            String current_word = words.poll();
            int current_length = length.poll();
            
            System.out.println("current_word = " + current_word + "\ncurrent_length = "+ current_length);
            if(current_word.equals(end))
                return current_length;
                
            char[] ca;
            for(int n = 0; n < current_word.length(); n++)
            {
                ca = current_word.toCharArray();
                for(char c = 'a'; c<='z'; c++)
                {
                    if(c == ca[n])
                    {
                        continue;
                    }
                    else
                    {
                        ca[n] = c;
                        String newWord = new String(ca);
                        if(dict.contains(newWord))
                        {
                        	System.out.println("contains:" + newWord);
                            words.add(newWord);
                            length.add(current_length+1);
                            dict.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    public static void main(String args[])
    {
    	HashSet<String> dict = new HashSet<String>(); 
    	dict.add("a");
    	dict.add("b");
    	dict.add("c");
    	
    	
    	System.out.println(ladderLength("a","c",dict));
    }
    
}
