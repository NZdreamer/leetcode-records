class Solution {
    public String rotateUp(String cur, int i) {
        char[] ca = cur.toCharArray();
        if (ca[i] == '9') { 
            ca[i] = '0';
            // res = cur.substring(0, i) + '0' + cur.substring(i, 4);    // String is immutable!!
        }
        else ca[i] += 1;
        return String.valueOf(ca);
    }
    
    public String rotateDown(String cur, int i) {
        char[] ca = cur.toCharArray();
        if (ca[i] == '0') ca[i] = '9';
        else ca[i] -= 1;
        return String.valueOf(ca);
    }
    
    
    public int openLock(String[] deadends, String target) {
        String init = "0000";
        // Set<String> deadSet = new HashSet<>(); // String set.contains use .equals to compare two strings!!
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            visited.add(deadend);
        }
        Queue<String> q = new LinkedList<>();
        if (!visited.contains(init)) {
            q.offer(init);
            visited.add(init);
        }

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) { // size of current layer
                String cur = q.poll();
                if (cur.equals(target)) return depth;
                // if (visited.contains(cur)) return -1;
                // visited.add(cur);
                for (int i = 0; i < 4; i++) {   // add every possible child node based on current node
                    String up = rotateUp(cur, i);
                    String down = rotateDown(cur, i);
                    // if (!deadSet.contains(up) && !visited.contains(up)) {
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);    // 一定要在这里加入visited，否则testcase3 TLE。 why？？
                    }
                    // if (!deadSet.contains(down) && !visited.contains(down)) {
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);  
                    }
                }
                size--;
            }
            depth++;
        }
        return -1;
    }
//     Set<String> deads = new HashSet<>();
//     for (String s : deadends) deads.add(s);
//     // 记录已经穷举过的密码，防止走回头路
//     Set<String> visited = new HashSet<>();
//     Queue<String> q = new LinkedList<>();
//     // 从起点开始启动广度优先搜索
//     int step = 0;
//     q.offer("0000");
//     visited.add("0000");
    
//     while (!q.isEmpty()) {
//         int sz = q.size();
//         /* 将当前队列中的所有节点向周围扩散 */
//         for (int i = 0; i < sz; i++) {
//             String cur = q.poll();
            
//             /* 判断是否到达终点 */
//             if (deads.contains(cur))
//                 continue;
//             if (cur.equals(target))
//                 return step;
            
//             /* 将一个节点的未遍历相邻节点加入队列 */
//             for (int j = 0; j < 4; j++) {
//                 String up = rotateUp(cur, j);
//                 if (!visited.contains(up)) {
//                     q.offer(up);
//                     visited.add(up);
//                 }
//                 String down = rotateDown(cur, j);
//                 if (!visited.contains(down)) {
//                     q.offer(down);
//                     visited.add(down);
//                 }
//             }
//         }
//         /* 在这里增加步数 */
//         step++;
//     }
//     // 如果穷举完都没找到目标密码，那就是找不到了
//     return -1;
//     }
}