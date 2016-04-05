package dfs;

import java.util.HashSet;

/**
 * Created by shuailu on 2/11/16.
 */
public class FriendsCycle {


    public static void main(String[] args) {
        boolean[][] friends1 = {
            {true, true, true, false, false},
            {true, true, false, false, true},
            {true, false, true, true, false},
            {false, false, true, true, true},
            {false, true, false, true, true}
        };   //answer: 1


        boolean[][] friends2 = {
            {true, true, false, false},
            {true, true, false, false},
            {false, false, true, true},
            {false, false, true, true}
        };    //answer: 2

        boolean[][] friends3 = {
            {true, false, false, false},
            {false, true, false, false},
            {false, false, true, true},
            {false, false, true, true}
        };    //answer: 3


        boolean[][] friends4 = {
            {true, false, false, false},
            {false, true, false, false},
            {false, false, true, false},
            {false, false, false, true}
        };    //answer: 4

        System.out.println(getCycleNum(friends1));
        System.out.println(getCycleNum(friends2));
        System.out.println(getCycleNum(friends3));
        System.out.println(getCycleNum(friends4));


        System.out.println(getCycleNumUnionFind(friends1));
        System.out.println(getCycleNumUnionFind(friends2));
        System.out.println(getCycleNumUnionFind(friends3));
        System.out.println(getCycleNumUnionFind(friends4));
    }

    public static int getCycleNum(boolean[][] friends) {
        int count = 0;

        HashSet<Integer> marked = new HashSet<Integer>();

        for (int row = 0; row < friends.length; row++) {
            if (!marked.contains(row)) {
                //HashSet<Integer> visited = new HashSet<Integer>();
                markAllFriends(friends, marked, row);
                //marked.addAll(visited);
                count++;
            }
        }
        return count;
    }

    private static void markAllFriends(boolean[][] friends, HashSet<Integer> cycle, int current) {
        if (current > friends.length || current < 0) {
            return;
        }
        for (int n = 0; n < friends.length; n++) {
            if (!cycle.contains(n) && n != current && friends[current][n]) {
                cycle.add(n);
                markAllFriends(friends, cycle, n);
            }
        }
    }


    private static int getCycleNumUnionFind(boolean[][] friends) {
        int length = friends.length;
        int[] relation = new int[length];

        for (int n = 0; n < length; n++) {
            relation[n] = n;
        }

        //union
        for (int row = 1; row < length; row ++) {
            for (int col = 0; col < row; col ++) {
                if (friends[row][col]) {
                    for (int n = 0; n < relation.length; n++) {
                        if (relation[n] == col) {
                            relation[n] = row;
                        }
                    }
                }
            }
        }
        //find
        HashSet<Integer> nums = new HashSet<Integer>();
        for (int aRelation : relation) {
            nums.add(aRelation);
        }
        return nums.size();
    }
}
