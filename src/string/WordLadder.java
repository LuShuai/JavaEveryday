package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


/**
 * Created by shuailu on 6/8/16.
 */
public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        int result = 0;
        if (start.length() != end.length() || start.length() == 0 || dict == null) {
            return result;
        }
        dict.add(start);
        dict.add(end);
        //cal the path length
        Queue<String> words = new LinkedList<>();
        Queue<Integer> length = new LinkedList<>();
        words.add(start);
        length.add(1);
        while (!words.isEmpty()) {
            String currentWord = words.poll();
            int currentLength = length.poll();
            if (currentWord.equals(end)) {
                return currentLength;
            }
            char[] ca;
            for (int n = 0; n < currentWord.length(); n++) {
                ca = currentWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != ca[n]) {
                        ca[n] = c;
                        String newWord = new String(ca);
                        if (dict.contains(newWord)) {
                            words.add(newWord);
                            length.add(currentLength + 1);
                            dict.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    /*
        return one possible shortest path
        start = "hit";  end = "cog";
        wordList = ["hot","dot","dog","lot","log"]
        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    */
    public static LinkedList<String> getShortestPath(String start, String end, HashSet<String> dict) {
        LinkedList<String> ladder = new LinkedList<>();
        if (start.equals(end)) {
            return ladder;
        }
        if (dict == null || dict.size() == 0) {
            return null;
        }
        Queue<String> wordQueue = new LinkedList<>();
        Queue<LinkedList<String>> ladderQueue = new LinkedList<>();
        wordQueue.add(start);
        ladderQueue.add(new LinkedList<String>());

        while (!wordQueue.isEmpty()) {
            String currentWord = wordQueue.remove();
            LinkedList<String> currentLadder = ladderQueue.remove();

            char[] ca = currentWord.toCharArray();
            for (int n = 0; n < ca.length; n++) {
                char originalChar = ca[n];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != originalChar) {
                        ca[n] = c;
                        String nextWord = new String(ca);

                        if (nextWord.equals(end)) {
                            currentLadder.addLast(currentWord);
                            currentLadder.addLast(end);
                            return currentLadder;
                        }

                        if (dict.contains(nextWord)) {
                            wordQueue.add(nextWord);
                            LinkedList<String> nextLadder = new LinkedList<>(currentLadder);
                            nextLadder.addLast(currentWord);
                            ladderQueue.add(nextLadder);
                            dict.remove(nextWord);
                        }
                    }
                }
                ca[n] = originalChar;
            }
        }
        return ladder;
    }


    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }

        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                visited.add(cur);

                List<String> words = getNextWords(cur, wordList);
                for (String word : words) {
                    if (visited.contains(word)) continue;
                    if (word.equals(endWord)) return count;
                    queue.add(word);
                }
            }
        }
        return 0;

    }

    private static List<String> getNextWords(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                if (c == j) {
                    continue;
                }
                String newWord = word.substring(0, i) + j + word.substring(i+1);
                if (dict.contains(newWord)) {
                    res.add(newWord);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("lot");
        dict.add("dog");
        System.out.println(getShortestPath("hit", "cog", dict));
    }

}
