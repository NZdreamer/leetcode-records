import java.util.*;

public class Microsoft_oa {
    // you can also use imports, for example:


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


    public static int solution(String A, String B) {
        // write your code in Java SE 8
        char[] arra = A.toCharArray();
        char[] arrb = B.toCharArray();
        int res = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i; j < A.length(); j++) {
                HashMap<Character, Integer> hma = new HashMap<>();
                HashMap<Character, Integer> hmb = new HashMap<>();
                boolean flag = true;
                for (int k = i; k <= j; k++) {
                    hma.put(arra[k], hma.getOrDefault(arra[k], 0) + 1);
                    hmb.put(arrb[k], hmb.getOrDefault(arrb[k], 0) + 1);
                }

                for (char key : hma.keySet()) {
                    if (!hmb.containsKey(key)) {
                        flag = false;
                        break;
                    } else {
                        if (hmb.get(key) != hma.get(key)) {
                            flag = false;
                            break;
                        }
                    }
                }

                for (char key : hmb.keySet()) {
                    if (!hma.containsKey(key)) {
                        flag = false;
                        break;
                    } else {
                        if (hmb.get(key) != hma.get(key)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) res++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(solution("dBacaAA", "caBdaaA"));
    }
}