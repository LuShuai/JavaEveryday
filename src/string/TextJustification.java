package string;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int length = words[0].length();
        int start = 0;
        int end = 0;
        for (int n = 1; n < words.length; n++) {
            int nextLength = length + words[n].length() + 1;
            if (nextLength <= maxWidth) {
                end = n;
                length = nextLength;
            } else {
                res.add(justifyLine(words, start, end, maxWidth));
                start = end = n;
                length = words[n].length();
            }
            if (n == words.length - 1) {
                res.add(justifyLastLine(words, start, end, maxWidth));
            }
        }
        return res;
    }

    private static String justifyLine(String[] words, int start, int end, int maxWidth) {
        int blankNum = end - start;
        if (blankNum == 0) {
            return justifyLastLine(words, start, end, maxWidth);
        }
        int wordsLength = 0;
        for (int n = start; n <= end; n++) {
            wordsLength += words[n].length();
        }
        int blankLength = maxWidth - wordsLength;
        int blank = blankLength / blankNum;
        int padNum = blankLength % blankNum;
        StringBuilder sb = new StringBuilder();
        for (int n = start; n <= end; n++) {
            sb.append(words[n]);
            if (n != end) {
                int between = blank;
                if (n - start + 1 <= padNum) {
                    between++;
                }
                for (int m = 0; m < between; m++) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    private static String justifyLastLine(String[] words, int start, int end, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int n = start; n <= end; n++) {
            sb.append(words[n]);
            if (n != end) {
                sb.append(' ');
            }
        }
        int paddingNum = maxWidth - sb.length();
        for (int n = 0; n < paddingNum; n++) {
            sb.append(' ');
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        //String[] sa = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] sa = {"Listen", "to", "many,", "speak", "to", "a", "few."};
        print(fullJustify(sa, 6));

    }

    public static void print(List<String> as) {
        for (String s : as) {
            System.out.println("[" + s + "]");
        }
    }

}
