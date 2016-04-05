package arrays;

import java.util.Arrays;

/**
 * Created by shuailu on 2/22/16.
 */
public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = predict(board[row][col], getLiveNeighborNum(board, row, col));
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 1;
                } else if (board[row][col] == 3) {
                    board[row][col] = 0;
                }
            }
        }
    }

    private static int predict(int current, int numOfLiveNeighbor) {
        if (current == 1) {
            //currently live case
            if (numOfLiveNeighbor < 2 || numOfLiveNeighbor > 3) {
                return 3;
            } else {
                return 1;
            }
        } else {
            //currently dead case
            if (numOfLiveNeighbor == 3) {
                return 2;
            } else {
                return 0;
            }
        }
    }

    private static int getLiveNeighborNum(int[][] board, int row, int col) {
        int count = 0;
        for (int m = Math.max(0, row - 1); m < Math.min(row + 2, board.length); m++) {
            for (int n = Math.max(0, col - 1); n < Math.min(col + 2, board[0].length); n++) {
                if (m == row && n == col) {
                    continue;
                }
                if (board[m][n] == 1 || board[m][n] == 3) {
                    ++count;
                }
            }
        }
        System.out.println(row + ", " + col + ": " + count);
        return count;
    }

    public static void main(String[] args) {
        int[][] board = {
            {1, 1},
            {1, 0}
        };
        gameOfLife(board);
        for (int[] line : board) {
            System.out.println(Arrays.toString(line));
        }
    }
}
