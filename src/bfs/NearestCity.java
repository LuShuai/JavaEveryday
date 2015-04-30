package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by shuailu on 3/30/15.
 */

/*
*   Give a map (2d array of integers)
*   and a list of cities (nodes in the map)
*   fill all the other nodes on the map with the distance to its nearest city
*
* */


public class NearestCity {
    public static int[][] getMap(int rowNum, int colNum) {
        if (rowNum <=0 || colNum < 0) {
            return null;
        }
        int[][] map = new int[rowNum][colNum];
        return map;
    }

    public List<Node> getCities(int[][] map, int cityNum) {
        if (map == null || map.length ==0) {
            return null;
        }
        int max = map.length * map[0].length;
        if (cityNum > max) {
            //error
            return null;
        }
        HashSet<Node> cities = new HashSet<Node>();
        List<Node> res = new LinkedList<Node>();
        int count = 0;
        Random random = new Random();
        while (count < cityNum) {
            int row = random.nextInt(map.length);
            int col = random.nextInt(map[0].length);
            Node node = new Node(row, col);
            if (!cities.contains(node)) {
                cities.add(node);
                res.add(node);
                count++;
            }
        }
        return res;
    }


    //TEST
    public static void main(String[] args) {
        NearestCity tester = new NearestCity();
        int map[][] = getMap(4, 5);
        List<Node> cities = tester.getCities(map, 19);

        for (Node node : cities) {
            System.out.println(node);
        }
        System.out.println(cities.size());

        Node node1 = new Node(1, 1);
        Node node2 = new Node(1, 2);
        Node node3 = new Node(1, 1);
        Node node4 = new Node(1, 2);

        System.out.println(node1.equals(node3));
        HashSet<Node> set = new HashSet<Node>();
        set.add(node1);
        System.out.println(set.contains(node3));

        for (Node in : set) {
            System.out.println(in.equals(node3));
        }


        String a = "x";
        String b = "X";
        String c = "x";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

    }
}
