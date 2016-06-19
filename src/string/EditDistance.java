package string;

/* 
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
 */

public class EditDistance {

    public static int getDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1 == null ? 0 : word1.length();
        }
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] distMap = new int[len1 + 1][len2 + 1];
        //dist[x][y] notes the distance of word1.substring(0, x + 1), word2.substring(0, y + 1);

        //init map with base cases
        for (int n = 0; n < len1; n++) {
            distMap[n][0] = n;
        }
        for (int n = 0; n < len2; n++) {
            distMap[0][n] = n;
        }

        for (int row = 1; row <= len1; row++) {
            for (int col = 1; col <= len2; col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    distMap[row][col] = distMap[row - 1][col - 1];
                } else {
                    //in terms of word1
                    int toReplace = distMap[row - 1][col - 1];
                    int toAdd = distMap[row - 1][col];
                    int toDelete = distMap[row][col - 1];
                    distMap[row][col] = Math.min(toReplace, Math.min(toAdd, toDelete)) + 1;
                }
            }
        }
        return distMap[len1][len2];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1 = "a";
        String s2 = "b";
        String s3 = "aa";
        String s4 = "hello, world";
        String s5 = "hello";
        String s6 = "zz";

//        System.out.println(getDistance(s1, s1));
//        System.out.println(getDistance(s1, s2));
//        System.out.println(getDistance(s1, s3));
//        System.out.println(getDistance(s2, s3));
//        System.out.println(getDistance(s3, s4));
//        System.out.println(getDistance(s4, s5));
        System.out.println(getDistance(s1, s6));

    }

}
