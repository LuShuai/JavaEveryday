package someTest.BattleShip;

/**
 * Created by shuailu on 5/5/16.
 */
public class Location {
    private int x;
    private int y;
    private boolean hit;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.hit = false;
    }
}
