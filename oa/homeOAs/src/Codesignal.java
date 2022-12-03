import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Codesignal {
    int[] solution(int[] memory, int[][] queries) {
//        HashMap<Integer, List<Integer>> hm = new HashMap<>();
//        int Id = 1;
//        int[] res = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            int type = queries[i][0];
//            int xorid = queries[i][1];
//            if (type == 0) {
//                int start = -1;
//                for (int j = 0; j < memory.length; j++) {
//                    if (memory[j] == 1) continue;
//                    else {
//                        if (j + xorid <= memory.length) {
//                            for (int k = j; k  < j  + xorid; k++) {
//                                if (memory[k] == 1) break;
//                                if (k == j + xorid - 1) start = j;
//                            }
//                        }
//                    }
//                    if (start != -1) {
//                        res[i] = start;
//                        List<Integer> tmp = new ArrayList<>();
//                        for (int m = start; m < start + xorid; m++) {
//                            tmp.add(m);
//                            memory[m] = 1;
//                        }
//                        hm.put(Id++, tmp);
//                        break;
//                    }
//                }
//                res[i] = start;
//            }
//            else {
//                if (hm.containsKey(xorid)) {
//                    List<Integer> tmp = hm.get(xorid);
//                    for (int j : tmp) {
//                        memory[j] = 0;
//                    }
//                    res[i] = tmp.size();
//                    hm.remove(xorid);
//                }
//                else {
//                    res[i] = -1;
//                }
//            }
//        }
//        return res;

         HashMap<Integer, int[]> ids = new HashMap<>();
         TreeMap<Integer, Integer> zeros = new TreeMap<>();
         int z = 0;
         int size = 0;
         while (z < memory.length) {
             if (memory[z] == 1) z++;
             while (z < memory.length && memory[z] == 0) {
                 size++;
                 z++;
             }
             zeros.put(z - size, size);
             z++;
             size = 0;
         }

         int[] res = new int[queries.length];
         for (int i = 0; i < res.length; i++) {
             res[i] = -1;
         }
         int id = 1;
         for (int i = 0; i < queries.length; i++) {
             if (queries[i][0] == 0) {
                 int need = queries[i][1];
                 for (int start : zeros.keySet()) {
                     int curSize = zeros.get(start);
                     if (curSize >= need) {
                         if (curSize > need) {
                             zeros.put(start + need, curSize - need);
                         }
                         zeros.remove(start);
                         res[i] = start;
                         ids.put(id, new int[]{start, need});
                         id++;
                         break;
                     }
                 }
             }
             else {
                 int eraseId = queries[i][1];
                 if (ids.containsKey(eraseId)) {
                     int[] value = ids.get(eraseId);
                     ids.remove(eraseId);
                     res[i] = value[1];
                     for (int start : zeros.keySet()) {
                         if (start + zeros.get(start) == value[0]) {
                             zeros.put(start, zeros.get(start) + value[1]);
                         }
                         if (value[0] + value[1] == start) {
                             zeros.put(value[0], value[1] + zeros.get(start));
                             zeros.remove(start);
                         }
                     }
                 }
             }
         }
         return res;
    }

}
