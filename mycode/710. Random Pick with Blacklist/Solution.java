class Solution {
    HashMap<Integer, Integer> map;
    Random random;
    int blackNum;
    int size;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        blackNum = blacklist.length;
        for (int b : blacklist) {
            map.put(b, 0);
        }
        int last = n - 1;
        size = n - blackNum;
        for (int i = 0; i < blackNum; i++) {
            if (blacklist[i] >= size) {
                continue;
            }
            while (map.containsKey(last)) {
                last--;
            }
            map.put(blacklist[i], last);
            last--;
        }

        
    }
    
    public int pick() {
        int num = random.nextInt(size);
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return num;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */



class Solution {
    HashMap<Integer, Integer> map;
    Random random;
    int blackNum;
    int size;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        blackNum = blacklist.length;
        for (int b : blacklist) {
            map.put(b, 0);
        }
        int last = n - 1;
        size = n - blackNum;
        Queue<Integer> q = new LinkedList<>();
        for (int i = size; i < n; i++) {
            if (map.containsKey(i)) continue;
            q.add(i);
        }
        for (int i = 0; i < blackNum; i++) {
            if (blacklist[i] >= size) continue;
            map.put(blacklist[i], q.poll());
        }
        // for (int i = 0; i < blackNum; i++) {
        //     if (blacklist[i] >= size) {
        //         continue;
        //     }
        //     while (map.containsKey(last)) {
        //         last--;
        //     }
        //     map.put(blacklist[i], last);
        //     last--;
        // }

        
    }
    
    public int pick() {
        int num = random.nextInt(size);
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return num;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */