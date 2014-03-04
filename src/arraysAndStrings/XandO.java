package arraysAndStrings;
import java.util.LinkedList;
import java.util.Queue;

public class XandO 
{
    class node
    {
        int X;
        int Y;
        node(int x, int y)
        {
            X = x;
            Y = y;
        }
    }
    
    
    //mark every escaped 'O' into 'E'
    public void mark(char[][] board)
    {
    	if(board == null || board.length == 0)
            return ;
            
        int row_nums = board.length;
        int col_nums = board[0].length;
        if(row_nums<=1 || col_nums<=1)
            return;
        
        Queue<node> q = new LinkedList<node>();
        
        for(int row = 0; row < row_nums; row++)
        {
        	if(board[row][0] == 'O')
        	{
        		board[row][0] = 'E';
        		q.add(new node(row, 0));
        	}
        	if(board[row][col_nums-1] == 'O')
        	{
        		board[row][col_nums-1] = 'E';
        		q.add(new node(row, col_nums-1));
        	}
        }
        for(int col = 0; col < col_nums; col++)
        {
        	if(board[0][col] == 'O')
        	{
        		board[0][col] = 'E';
        		q.add(new node(0, col));
        	}
        	if(board[row_nums-1][col] == 'O')
        	{
        		board[row_nums-1][col] = 'E';
        		q.add(new node(row_nums-1, col));
        	}
        }
        
        while(!q.isEmpty())
        {
        	node n = q.poll();
        	//check upper node
        	if(n.X > 0 && board[n.X-1][n.Y] == 'O')
        	{
        		board[n.X-1][n.Y] = 'E';
        		q.add(new node(n.X-1,n.Y));
        	}
        	//check lower node
        	if(n.X < row_nums-1 && board[n.X+1][n.Y] == 'O')
        	{
        		board[n.X+1][n.Y] = 'E';
        		q.add(new node(n.X+1, n.Y));
        	}
        	//check left node
        	if(n.Y > 0 && board[n.X][n.Y-1] == 'O')
        	{
        		board[n.X][n.Y-1] = 'E';
        		q.add(new node(n.X, n.Y-1));
        	}
        	//check right node
        	if(n.Y < col_nums-1 && board[n.X][n.Y+1] == 'O')
        	{
        		board[n.X][n.Y+1] = 'E';
        		q.add(new node(n.X, n.Y+1));
        	}
        }
    	
    }
    
    
    public void solve(char[][] board) 
    {
        mark(board);
    }
}
