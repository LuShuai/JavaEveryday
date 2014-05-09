package someTest;

public class FindPath 
{
    public static int returnSumForBestPath(int[][] matrix) 
    {
        int row_num = matrix.length;
        int col_num = matrix[0].length;
        
        int[][] min = new int[row_num][col_num];
        
        for(int r = 0; r < row_num; r++)
        {
            for(int c = 0; c < col_num; c++)
            {
                if(c == 0 && r == 0)
                    min[r][c] = matrix[r][c];
                else if(c == 0)
                    min[r][c] = min[r-1][c] + matrix[r][c];
                else if(r == 0)
                    min[r][c] = min[r][c-1] + matrix[r][c];
                else
                    min[r][c] = Integer.MIN_VALUE;
            }
        }
        
        return returnSumForBestPath(matrix, min, row_num-1, col_num-1);
        
    }
    
    private static int returnSumForBestPath(int[][] matrix, int[][] min, int row, int col)
    {
        if(min[row][col] != Integer.MIN_VALUE)
            return min[row][col];
        
        min[row][col] = Math.min( returnSumForBestPath(matrix, min, row-1, col), returnSumForBestPath(matrix, min, row, col-1)) + matrix[row][col];
        return min[row][col];
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
            {1,  5,  9},
            {2,  4,  6},
            {10, 5,  3}
        };
        //should return 15
        System.out.println(returnSumForBestPath(matrix));
    }
}