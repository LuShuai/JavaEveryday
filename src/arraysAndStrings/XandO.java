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
    public void solve(char[][] board) 
    {
        if(board == null || board.length == 0)
            return ;
            
        int row_nums = board.length;
        int col_nums = board[0].length;
        if(row_nums<=1 || col_nums<=1)
            return;
            
        boolean[][] checked = new boolean[row_nums][col_nums];
        for(int n = 0; n < row_nums; n++)
            for(int m = 0; m < col_nums; m++)
                checked[n][m] = false;
        
        Queue<node> q = new LinkedList<node>();
        LinkedList<node> current_nodes = new LinkedList<node>();
        boolean escaped = false;
        
        for(int row = 0; row < row_nums; row ++)
        {
            for(int col = 0; col < col_nums; col ++)
            {
                if(board[row][col] == 'O')
                {
                    if(!(row == 0 || col == 0 || row == row_nums - 1 || col == col_nums - 1) && !checked[row][col])
                    {
                    	System.out.println("X =" + row);
                    	System.out.println("Y =" + col);
                        escaped = false;
                        current_nodes.clear();
                        q.clear();
                        checked[row][col] = true;
                        q.add(this.new node(row, col));
                        while(!q.isEmpty())
                        {
                            node current = q.remove();
                            current_nodes.add(current);
                            if(board[current.X+1][current.Y] == 'O' && checked[current.X+1][current.Y] == false)
                            {
                                if(current.X+1 == row_nums-1 || (current.X+2 < row_nums && current.X+2 == row_nums-1 && board[current.X+2][current.Y] == 'O'))
                                {
                                    escaped = true;
                                    break;
                                }

                                q.add(new node(current.X+1, current.Y));
                                checked[current.X+1][current.Y] = true;
                            }
                            System.out.println("c_X =" + current.X);
                            System.out.println("c_Y =" + current.Y);
                            if(board[current.X][current.Y+1] == 'O' && checked[current.X][current.Y+1] == false)
                            {
                                if(current.Y+1 == col_nums-1 || (current.Y+2 < col_nums && current.Y+2 == col_nums-1 && board[current.X][current.Y+2] == 'O'))
                                {
                                    escaped = true;
                                    break;
                                }
                                q.add(new node(current.X, current.Y+1));
                                checked[current.X][current.Y+1] = true;
                            }
                        }
                        if(!escaped)
                        {
                            for(node o: current_nodes)
                            {
                                board[o.X][o.Y] = 'X';
                            }
                        }
                    }
                    //mark all connected 'O' as checked
                    else
                    {
                    	q.clear();
                        q.add(this.new node(row, col));
                        if(row == 0 || col == 0)//left --> right, up --> down
                        {
                            while(!q.isEmpty())
                            {
                                node n = q.remove();
                                checked[n.X][n.Y] = true;
                                if(n.X+1 < row_nums)
                                {
                                    if(board[n.X+1][n.Y] == 'O')
                                        q.add(new node(n.X+1, n.Y));
                                }
                                if(n.Y+1 < col_nums)
                                {
                                    if(board[n.X][n.Y+1] == 'O')
                                        q.add(new node(n.X, n.Y+1));
                                }
                            }
                        }
                        else
                        {
                            while(!q.isEmpty())
                            {
                                node n = q.remove();
                                checked[n.X][n.Y] = true;
                                if(n.X-1 >= 0)
                                {
                                    if(board[n.X-1][n.Y] == 'O')
                                        q.add(new node(n.X-1, n.Y));
                                }
                                if(n.Y-1 >= 0)
                                {
                                    if(board[n.X][n.Y-1] == 'O')
                                        q.add(new node(n.X, n.Y-1));
                                }
                            }
                            
                        }
                        
                    }
                }
            }
            
        }
    }
}
