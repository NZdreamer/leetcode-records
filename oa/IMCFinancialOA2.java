import java.util.*;

public class IMCFinancialOA2 {
    public int[] getResult(int[] arrival, int[] street) {
        int n = arrival.length;
        PriorityQueue<int[]> q1 = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        }); // 1st ave
        PriorityQueue<int[]> q2 = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        }); // main st
        int[] res = new int[n];
        int curTime = 0;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (street[i] == 1) {
                q1.add(new int[]{arrival[i], i});
            }
            else {
                q2.add(new int[]{arrival[i], i});
            }
        }

        while (!q1.isEmpty() || !q2.isEmpty()) {
            int curID;  // 0: q2 main st; 1: q1 1st ave

            if (q1.isEmpty()) curID = 0;
            else if (q2.isEmpty()) curID = 1;
            else {
                int time1 = q1.peek()[0];
                int time2 = q2.peek()[0];
                if (curTime < time1 && curTime < time2) {
                    if (time1 < time2) curID = 1;
                    else if (time2 < time1) curID = 0;
                    else {
                        curID = 1;
                    }
                }
                else if (curTime < time1) {
                    curID = 0;
                }
                else if (curTime < time2) {
                    curID = 1;
                }
                else {
                    if (last == 1) {
                        curID = 1;
                    }
                    else {
                        curID = 0;
                    }
                }
            }
            
            int[] next;
            if (curID == 0) {
                next = q2.poll();
            }
            else {
                next = q1.poll();
            }
            int car = next[1];
            int time = next[0];
            last = curID;
            curTime = Math.max(time, curTime)  + 1;
            res[car] = curTime;
        }
        return res;
    }



    public static List<Integer> getResult(List<Integer> arrival, List<Integer> street) {
        int n = arrival.size();
        // PQ store arrival time and the index of car
        PriorityQueue<int[]> q1 = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        }); // 1st ave
        PriorityQueue<int[]> q2 = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        }); // main st
        
        int[] resarr = new int[n];
        List<Integer> res = new ArrayList<>();
        
        int curTime = 0;
        int last = -1;
        
        for (int i = 0; i < n; i++) {
            if (street.get(i) == 1) {
                q1.add(new int[]{arrival.get(i), i});
            }
            else {
                q2.add(new int[]{arrival.get(i), i});
            }
        }
        
        
        while (!q1.isEmpty() || !q2.isEmpty()) {
            int curID;
            if (q1.isEmpty()) curID = 0;
            else if (q2.isEmpty()) curID = 1;
            else {
                int time1 = q1.peek()[0];
                int time2 = q2.peek()[0];
                if (last == -1) {
                    if (time1 < time2) curID = 1;
                    else if (time2 < time1) curID = 0;
                    else curID = 1;
                }
                else if (last == 1 && time1 <= curTime) {
                    curID = 1;
                }
                else if (last == 0 && time2 <= curTime) {
                    curID = 0;
                }
                else {
                    last = -1;
                    continue;
                }
            }
            int[] next;
            if (curID == 0) next = q2.poll();
            else next = q1.poll();
            
            last = curID;
            int time = next[0];
            int car = next[1];
            curTime = Math.max(time, curTime) + 1;
            resarr[car] = curTime - 1;
        }
        
        for (int i = 0; i < n; i++) {
            res.add(resarr[i]);
        }
        return res;
    }

}
