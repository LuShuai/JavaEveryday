package someTest.BattleShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by shuailu on 5/5/16.
 */
public class Board {

    private static final int BOARD_SIZE = 10;

    List<Ship> ships = new ArrayList<Ship>(3);

    public Board() {
        this(false);
    }

    public Board(boolean staticMap) {
        //generate ships
        //TODO: replace ship generation by random generation logic
        if (staticMap) {
            generateMockShips();
        } else {
            generateShips();
        }
    }


    private void generateShips() {
        for (int length = 5; length >= 3; length--) {
            while (!generateShip(length)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean generateShip(int length) {

        Random random = new Random();

        List<Location> locations = new ArrayList<Location>(length);
        int dynamicStartingPoint = random.nextInt(BOARD_SIZE - length + 1);
        int staticStartingPoint = random.nextInt(BOARD_SIZE);
        boolean vertical = random.nextBoolean();
        //vertically dynamic
        for (int offset = 0; offset < length; offset++) {
            int runner = dynamicStartingPoint + offset;
            int sitter = staticStartingPoint;
            if (vertical) {
                if (alreadyHasShip(runner, sitter)) {
                    return false;
                }
                locations.add(new Location(runner, sitter));
            } else {
                if (alreadyHasShip(sitter, runner)) {
                    return false;
                }
                locations.add(new Location(sitter, runner));
            }
        }
        Ship ship = new Ship(locations);
        ships.add(ship);
        return true;
    }

    private boolean alreadyHasShip(int x, int y) {
        for (Ship ship : ships) {
            if (ship.at(x, y)) {
                return true;
            }
        }
        return false;
    }


    public boolean generateMockShips() {
        //ship1 from 1,1 -- > 5,1
        ships.add(new Ship(Arrays.asList(new Location(1, 1), new Location(2, 1), new Location(3, 1), new Location(4, 1),
                                         new Location(5, 1))));

        //ship2 from 3,3 -- > 3,6
        ships.add(
            new Ship(Arrays.asList(new Location(3, 3), new Location(3, 4), new Location(3, 5), new Location(3, 6))));

        //ship3 from 4,5 -- > 6,5
        ships.add(new Ship(Arrays.asList(new Location(4, 5), new Location(5, 5), new Location(6, 5))));
        return false;
    }

    public HitResult hit(int x, int y) {
        for (Ship ship : ships) {
            if (ship.hit(x, y)) {
                return ship.sunk() ? HitResult.SUNK : HitResult.HIT;
            }
        }
        return HitResult.MISS;
    }

    public void showMap() {
        boolean[][] map = new boolean[BOARD_SIZE][BOARD_SIZE];
        for (int m = 0; m < BOARD_SIZE; m++) {
            for (int n = 0; n < BOARD_SIZE; n++) {
                map[m][n] = false;
            }
        }
        for (Ship ship : ships) {
            for (Location location : ship.getLocations()) {
                map[location.getX()][location.getY()] = true;
            }
        }

        for (int m = 0; m < BOARD_SIZE; m++) {
            for (int n = 0; n < BOARD_SIZE; n++) {
                if (map[m][n]) {
                    System.out.print("X\t");
                } else {
                    System.out.print("O\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.showMap();
        System.out.println();
        for (int m = 0; m < BOARD_SIZE; m++) {
            for (int n = 0; n < BOARD_SIZE; n++) {
                System.out.print(board.hit(m, n).getText() + "\t");
            }
            System.out.println();
        }
    }
}
