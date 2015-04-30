package bfs;

/**
 * Created by shuailu on 3/30/15.
 */
class Node {
    protected int row;
    protected int col;
    Node (int r, int c) {
        row = r;
        col = c;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == getClass()) {
            Node testNode = (Node) obj;
            return row == testNode.row && col == testNode.col;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return row * col;
    }

    @Override
    public String toString() {
        return "[" + row  +", " + col + "]";
    }
}
