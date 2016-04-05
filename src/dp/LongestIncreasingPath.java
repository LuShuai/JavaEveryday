package dp;

/**
 * Created by shuailu on 3/21/16.
 */
public class LongestIncreasingPath {

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //init note
        int[][] note = new int[matrix.length][matrix[0].length];
        for (int m = 0; m < note.length; m++) {
            for (int n = 0; n < note[0].length; n++) {
                note[m][n] = -1;
            }
        }

        int max = 0;
        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[0].length; n++) {
                max = Math.max(getLength(matrix, m, n, note), max);
            }
        }
        return max;
    }

    private static int getLength(int[][] matrix, int row, int col, int[][] note) {
        //already in note
        if (note[row][col] != -1) {
            return note[row][col];
        }

        int up, down, left, right;
        up = down = left = right = 0;

        //search up
        if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
            up = getLength(matrix, row - 1, col, note);
        }
        //search right
        if (col < matrix[0].length - 1 && matrix[row][col + 1] > matrix[row][col]) {

            right = getLength(matrix, row, col + 1, note);
        }
        //search down
        if (row < matrix.length - 1 && matrix[row + 1][col] > matrix[row][col]) {
            down = getLength(matrix, row + 1, col, note);
        }
        //search down
        if (col > 0 && matrix[row][col - 1] > matrix[row][col]) {
            left = getLength(matrix, row, col - 1, note);
        }

        note[row][col] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        return note[row][col];
    }

    public static void main(String[] args) {
        int[][] map = {
            {1, 3, 1, 5, 6, 7},
            {5, 4, 6, 7, 8, 8},
            {2, 4, 5, 6, 7, 8},
            {8, 6, 5, 4, 3, 2}
        };

        System.out.println(longestIncreasingPath(map));
    }
}
