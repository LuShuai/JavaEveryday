package someTest;

/**
 * Created by shuailu on 5/31/16.
 */
public class FindNextCharSearch {

    public static char findNextChar(char[] list, char c) {
        assert list.length > 0;
        int left = 0, right = list.length - 1;
        char result = list[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == c) {
                if (mid < list.length - 1) {
                    return list[mid + 1];
                } else {
                    return result;
                }
            } else if (list[mid] < c) {
                left = mid + 1;
            } else { //list[mid] > c
                result = list[mid];
                right = mid - 1;
            }
        }
        return result;
    }

    //recursive way
    public static char findNextCharRec(char[] list, char target) {
        char[] res = new char[1];
        res[0] = list[0];
        findNextCharRec(list, 0, list.length - 1, target, res);
        return res[0];
    }

    public static void findNextCharRec(char[] list, int start, int end, char target, char[] res) {
        if (end < start) {
            return;
        }
        int mid = start + (end - start) / 2;
        if (list[mid] == target) {
            if (mid < list.length - 1) {
                res[0] = list[mid + 1];
            }
            return;
        }
        if (target < list[mid]) {
            res[0] = list[mid];
            findNextCharRec(list, start, mid - 1, target, res);
        } else {
            findNextCharRec(list, mid + 1, end, target, res);
        }
    }

    public static void main(String[] args) {
        char[] list = {'c', 'f', 'j', 'p', 'v'};
        char[] target = {'a', 'c', 'f', 'k', 'v', 'z'};

        char[] list2 = {'a', 'c', 'e', 'g', 'i', 'j'};

        for (char c : target) {
            System.out.println(c + " -> " + findNextChar(list, c));
        }
        System.out.println("=================");
        for (char c : target) {
            System.out.println(c + " -> " + findNextCharRec(list, c));
        }


        //System.out.println('f' + " -> " + findNextChar(list2, 'f'));

//        System.out.println('k' + " -> " + findNextCharRec(list, 'k'));
    }
}
