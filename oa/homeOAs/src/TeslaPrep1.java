import java.util.*;

public class TeslaPrep1 {
//    public static String reverseButSpecialChar(String s) {
//        StringBuilder sb = new StringBuilder();
////        List<Character> list = new ArrayList<>();
//        TreeMap<Integer, Character> map = new TreeMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if ((c >= 'a' && c<= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
//                sb.append(c);
////                list.add(c);
//            }
//            else {
//                map.put(i, c);
//            }
//        }
//        sb.reverse();
////        int l = 0, r = list.size() - 1;
////        while (l < r) {
////            char tmp = list.get(l);
////            list.set(l, list.get(r));
////            list.set(r, tmp);
////            l++;
////            r--;
////        }
//        for (int i : map.keySet()) {
////            list.add(i, map.get(i));
//            sb.insert(i, map.get(i));
//        }
////        for (char c : list) {
////            sb.append(c);
////        }
//        return sb.toString();
//    }

    public static String reverseButSpecialChar(String s) {
        int l = 0, r = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (l < r) {
            char cl = s.charAt(l);
            while (!((cl >= 'a' && cl <= 'z') || (cl >= 'A' && cl <= 'Z') || (cl >= '0' && cl <= '9'))) {
                l++;
                cl = s.charAt(l);
            }
            char cr = s.charAt(r);
            while (!((cr >= 'a' && cr<= 'z') || (cr >= 'A' && cr <= 'Z') || (cr >= '0' && cr <= '9'))) {
                r--;
                cr = s.charAt(r);
            }
            sb.setCharAt(l, cr);
            sb.setCharAt(r, cl);
            l++;
            r--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ab!c,d";
        String res = reverseButSpecialChar(s);
        System.out.println(res);
    }
}
