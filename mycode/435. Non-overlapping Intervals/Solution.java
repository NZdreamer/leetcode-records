// greedy

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort the interval.end in accending order
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));

        // traverse interval array to get max number of non-overlapping intervals
        int cnt = 1;
        int end = intervals[0][1];  // need an end to record the last non-overlaaping intervals (intervals[i-1][1] is wrong)
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                cnt++;
                end = intervals[i][1];
            }
        }

        return intervals.length - cnt;
    }
}