import java.util.*;
public class zijieOA1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String general = in.nextLine();
        StringBuilder sb = new StringBuilder(general);
        Set<Integer> genIdxs = new HashSet<>();
        System.out.println(sb);
        int start = 0; int end = 0;
        for (int i = general.length() - 1; i >= 0; i--) {
            sb.append(general.charAt(i));
            if(general.charAt(i) == '}') end = i;
            if (general.charAt(i) == '{') {
                start = i;
                System.out.println("start: "+start);
                System.out.println("end: "+end);
                sb.delete(start, end + 1);
                genIdxs.add(start);
            }
        }

        while (n > 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            n--;
            String s = in.nextLine();
            System.out.println(isValid(sb, s, genIdxs));
        }
    }   
    
    public static boolean isValid(StringBuilder sb, String s, Set<Integer> genIdxs) {
        int i = 0; int j = 0;
        while (j < s.length()) {
            if (sb.charAt(i) == sb.charAt(j)) {
                i++;
                j++;
            }
            else {
                if (genIdxs.contains(i)) {
                    j++;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    

}

