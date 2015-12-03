package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {

    class Node {

        int X;
        int Y;

        Node(int x, int y) {
            X = x;
            Y = y;
        }
    }

    public void mark(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rowNums = board.length;
        int colNums = board[0].length;
        if (rowNums <= 1 || colNums <= 1) {
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        for (int n = 0; n < board.length; n++) {
            if (board[n][0] == 'O') {
                board[n][0] = 'E';
                q.add(new Node(n, 0));
            }
            if (board[n][board.length - 1] == 'O') {
                board[n][board.length - 1] = 'E';
                q.add(new Node(n, board.length - 1));
            }
        }
        for (int n = 0; n < board[0].length; n++) {
            if (board[0][n] == 'O') {
                board[0][n] = 'E';
                q.add(new Node(0, n));
            }
            if (board[board.length - 1][n] == 'O') {
                board[board.length - 1][n] = 'E';
                q.add(new Node(board.length - 1, n));
            }
        }

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (board[n.X][n.Y] == 'E') {
                continue;
            }
            board[n.X][n.Y] = 'E';
            //search top
            if (n.X > 0) {
                q.add(new Node(n.X - 1, n.Y));
            }
            //search right
            if (n.Y < board[0].length - 1) {
                q.add(new Node(n.X, n.Y + 1));
            }
            //search bot
            if (n.X < board.length - 1) {
                q.add(new Node(n.X + 1, n.Y));
            }
            //search left
            if (n.Y > 0) {
                q.add(new Node(n.X, n.Y - 1));
            }
        }
    }

    //public static void main(String[] args){

    //}

}
