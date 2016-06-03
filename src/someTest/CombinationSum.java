package someTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        DFS(candidates, 0, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public static void DFS(int[] candidates, int start, int target, int curVal, ArrayList<Integer> curList,
                           ArrayList<ArrayList<Integer>> res) {
        if (curVal == target) {
            System.out.println("save to list");
            res.add(new ArrayList<Integer>(curList));
            return;
        }
        for (int n = start; n < candidates.length; n++) {
            if (curVal + candidates[n] > target) {
                break;
            }
            curList.add(candidates[n]);
            DFS(candidates, n, target, curVal + candidates[n], curList, res);
            curList.remove(curList.size() - 1);
        }
    }

    public static List<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0 || target < 0) {
            return null;
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        DFS(num, target, 0, new ArrayList<Integer>(), 0, res);
        return res;
    }

    private static void DFS(int[] num, int target, int index, ArrayList<Integer> list, int currentVal,
                            ArrayList<ArrayList<Integer>> res) {
        if (currentVal == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int n = index; n < num.length; n++) {
            if (currentVal + num[n] > target) {
                break;
            }
            list.add(num[n]);
            DFS(num, target, n + 1, list, currentVal + num[n], res);
            list.remove(list.size() - 1);
            while (n + 1 < num.length && num[n + 1] == num[n]) {
                ++n;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 1};
        System.out.println(combinationSum2(a, 2));
    }

}
