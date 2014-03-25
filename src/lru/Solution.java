package lru;

import java.io.*;
import java.util.HashMap;
import java.util.Arrays;
public class Solution 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        int num_of_commands = Integer.parseInt(br.readLine());
        Solution lru = new Solution(10);
        for(int n = 0; n < num_of_commands; n++)
        {
            String[] line = br.readLine().split(" ");
            String command = line[0];
            if(command.equals("SET"))
            {
                lru.set(line[1], line[2]);
            }
            else if(command.equals("GET"))
            {
                String res = lru.get(line[1]);
                if(res == null)
                    res = "NULL";
                System.out.println(res);
            }
            else if(command.equals("PEEK"))
            {
                String res = lru.peek(line[1]);
                if(res == null)
                    res = "NULL";
                System.out.println(res);
            }
            else if(command.equals("BOUND"))
            {
                lru.bound(Integer.parseInt(line[1]));
            }
            else if(command.equals("DUMP"))
            {
                lru.dump();
            }
            else
            {
                System.out.println(command + ": command not found!");
            }            
        }
    }
    class node
    {
        String val;
        String key;
        node next;
        node prev;
        public node(String k, String v)
        {
            key = k;
            val = v;
            next = prev = null;
        }
    }
    int MAX;
    
    node head, tail;
    HashMap<String, node> hash;
    
    public Solution(int capacity) 
    {
        MAX = capacity;
        hash = new HashMap<String, node>();
    }
    
    private int getSize()
    {
        return hash.keySet().size();
    }
    
    private void moveToHead(node n)
    {
        if(n == head || n == null)
            return;
        if(n == tail)
        {
            tail = n.prev;
            n.prev.next = null;
            n.prev = null;
            n.next = head;
            head.prev = n;
            head = n;
            return;
        }
        n.next.prev = n.prev;
        n.prev.next = n.next;
        n.next = head;
        head.prev = n;
        n.prev = null;
        head = n;
        return;
    }
    
    private void removeTail()
    {
        String k = tail.key;
        if(tail == head)
        {
            tail = head = null;
        }
        else
        {
           tail= tail.prev;
           tail.next = null;
        }
        hash.remove(k);
    }
    
    public void bound(int new_size)
    {
        while(hash.size() > new_size)
            removeTail();
        MAX = new_size;
    }
    
    public String get(String key) 
    {
        if(!hash.containsKey(key))
        {
            return null;
        }
        else
        {
            node n = hash.get(key);
            moveToHead(n);
            return n.val;
        }
    }
    
    public String peek(String key)
    {
        if(!hash.containsKey(key))
        {
            return null;
        }
        else
        {
            node n = hash.get(key);
            return n.val;
        }
    }
    
    public void dump()
    {
        if(hash.size() == 0)
            return;
        String[] strs = new String[hash.size()];
        int index = 0;
        for(String s : hash.keySet())
        {
            strs[index++] = s;
        }
        Arrays.sort(strs);
        for(int n = 0; n < strs.length; n++)
            System.out.println(strs[n] + " " + peek(strs[n]));
    }
    
    public void set(String key, String value) 
    {
        if(!hash.containsKey(key))
        {
            if(1 + getSize() > MAX)
            {
                removeTail();
                set(key, value);
            }
            else
            {
                node n = new node(key, value);
                if(head == null)
                {
                    head = tail = n; 
                }
                else
                {
                    head.prev = n;
                    n.next = head;
                    head = n;
                }
                hash.put(key, n);
            }
        }
        else
        {
            node n = hash.get(key);
            n.val = value;
            moveToHead(n);         
        }
    }
}