package dfs;

public class WordSearch{
	private static final boolean D = false;
	public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return word == null || word.length() == 0;
        if (board.length == board[0].length && board.length == 1)
            return board[0][0] == word.charAt(0) && word.length() == 1;
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if ( board[m][n] == word.charAt(0) && search(board, word, m, n) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean search(char[][] board, String word, int row, int col) {
    	if (D) {
    		System.out.println("searching: " + word + "   in row: " + row + "   col:" + col);
    	}
    	if (word == null || word.length() == 0) {
            return true;
        }
    	if (board[row][col] != word.charAt(0)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '*';
        //search top
        if (row > 0) {
            if (search(board, word.substring(1), row-1, col)) {
                return true;
            }
        }
        //search right
        if (col < board[0].length-1) {
            if (search(board, word.substring(1), row, col + 1)) {
                return true;
            }
        }
        //search bot
        if (row < board.length - 1) {
            if (search(board, word.substring(1), row + 1, col)) {
                return true;
            }
        }
        //search left
        if (col > 0) {
            if (search(board, word.substring(1), row, col - 1)) {
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }
	
	public static void main(String[] args)
	{
		char[][] board = {
				{'a','a'}	
		};
		System.out.println(exist(board, "a"));

	}

}
