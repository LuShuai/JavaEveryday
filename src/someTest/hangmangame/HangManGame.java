package someTest.hangmangame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by shuailu on 6/14/16.
 */
public class HangManGame {

    private static final int MAX_HP = 6;
    private static final String WORDS_FILE_PATH = "/Users/shuailu/Projects/shuai/JavaEveryday/src/someTest/hangmangame/words.txt";

    List<String> words;

    String answer;
    Map<Character, Set<Integer>> map;
    char[] current;
    Set<Character> triedChars;
    int hp;
    int revealed;

    public HangManGame() throws IOException {
        loadWords();
        this.answer = words.get(new Random().nextInt(words.size()));
        this.triedChars = new HashSet<>();
        this.hp = MAX_HP;
        this.revealed = 0;
        this.current = new char[answer.length()];
        this.map = new HashMap<>();
        for (int n = 0; n < answer.length(); n++) {
            char c = answer.charAt(n);
            current[n] = '_';
            Set<Integer> indexSet = map.get(c);
            if (indexSet == null) {
                indexSet = new HashSet<>();
                map.put(c, indexSet);
            }
            indexSet.add(n);
        }
    }

    public void loadWords() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(WORDS_FILE_PATH));
        String line;
        words = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            words.add(line);
        }
    }


    //print current status after guess, return true if won
    public Result guess(Character inputChar) {
        char c = Character.toLowerCase(inputChar);
        if (triedChars.contains(c)) {
            System.out.println("You've tried " + c + " already, try a different character!");
            return Result.CONTINUE;
        }
        triedChars.add(c);
        Set<Integer> indexSet = map.get(c);
        if (indexSet != null) {
            for (Integer index : indexSet) {
                ++revealed;
                current[index] = c;
            }
            if (revealed == answer.length()) {
                return Result.WON;
            }
            return Result.CONTINUE;
        }
        --hp;
        if (hp == 0) {
            return Result.LOSE;
        }
        return Result.CONTINUE;
    }

    public void startGame() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        showStatus();
        while (true) {
            try {
                System.out.println("Guess a letter:");
                String line = br.readLine().trim();
                if (line.length() > 1) {
                    System.out.println("Invalid input only 1 letter allowed");
                    showStatus();
                    continue;
                }
                char c = line.toCharArray()[0];
                Result result = guess(c);
                showStatus();
                if (result == Result.LOSE) {
                    System.out.println("You lose.... the answer is: " + answer);
                    break;
                }
                if (result == Result.WON) {
                    System.out.println("You won! HP left: " + hp);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showStatus() {
        for (char c : current) {
            System.out.print(c + " ");
        }
        System.out.println("\t HP left:" + hp);

    }


    public static void main(String[] args) throws IOException {
        HangManGame game = new HangManGame();
        game.startGame();
    }

}
