//253. Meeting Rooms II
//
//        Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
//
//        Example 1:
//
//        Input: intervals = [[0,30],[5,10],[15,20]]
//        Output: 2
//        Example 2:
//
//        Input: intervals = [[7,10],[2,4]]
//        Output: 1
//
//
//        Constraints:
//
//        1 <= intervals.length <= 104
//        0 <= starti < endi <= 106

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue();  // find the smallest end time among opened rooms
        int cnt = 0;
        for (int i = 0; i < intervals.length; i++) {
            // add the meeing to queue, record the end time
            heap.add(intervals[i][1]);
            // if the earliest end time > the start time of this meeting, we need a new room
            if (heap.peek() > intervals[i][0]) cnt++;
            // else, the earliest end meeting ends, poll it out from the queue
            else heap.poll();
        }
        return cnt;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        // initialize a heap, representing the ongoing meeting
        PriorityQueue<Integer> heap = new PriorityQueue();
        int res = 0;
        // traverse the sorted intervals
        // while start time >= top of the heap, poll
        // push the end time in the min heap
        for (int[] interval : intervals) {
            while (heap.size() != 0 && interval[0] >= heap.peek()) {
                heap.poll();
            }
            heap.add(interval[1]);
            res = Math.max(res, heap.size());
        }
        
        // return the max size of the heap during 
        return res;
    }
}