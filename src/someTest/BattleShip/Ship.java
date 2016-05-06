package someTest.BattleShip;

import java.util.List;

/**
 * Created by shuailu on 5/5/16.
 */
public class Ship {

    private int hp;
    List<Location> locations;

    public Ship() {
    }

    public Ship(List<Location> locations) {
        this.locations = locations;
        this.hp = locations.size();
    }

    public boolean sunk() {
        return getHp() == 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
        setHp(locations.size());

    }

    public boolean hit(int x, int y) {
        for (Location location : locations) {
            if (x == location.getX() && y == location.getY()) {
                if (!location.isHit()) {
                    setHp(getHp() - 1);
                }
                location.setHit(true);
                return true;
            }
        }
        return false;
    }

    public boolean at(int x, int y) {
        for (Location location : locations) {
            if (x == location.getX() && y == location.getY()) {
                return true;
            }
        }
        return false;
    }
}
