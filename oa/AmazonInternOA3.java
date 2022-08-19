import java.util.HashSet;

public class AmazonInternOA3 {
    public static void main(String[] args) {
        String psw = "abcdabc";
        int res = findPasswordUniqueness(psw);
        System.out.println(res);
    }

    public static int findPasswordUniqueness(String password) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (int j = 0; j < password.length(); j++) {            
            if (set.contains(password.charAt(j))) {
                set = new HashSet<>();
                res++;
            }
            set.add(password.charAt(j));
        }
        return res + 1;
    }
}
