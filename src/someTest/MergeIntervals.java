package someTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 5/17/16.
 */
public class MergeIntervals {

    public static class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        //sort internals
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if (interval1.start == interval2.start) {
                    return 0;
                }
                return interval1.start < interval2.start ? -1 : 1;
            }
        });

        List<Interval> res = new LinkedList<>();
        int start = -1;
        int end = -1;
        for (Interval interval : intervals) {
            if (start == -1) {
                start = interval.start;
                end = interval.end;
                continue;
            }
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(0, 1));
        intervals.add(new Interval(3, 4));
        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(6, 7));

        List<Interval> res = merge(intervals);
    }

}
