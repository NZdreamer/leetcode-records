import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class honor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Set<String> inputstr = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String tmp = scanner.nextLine();
            System.out.println(tmp);
            inputstr.add(tmp);
        }

        String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}";
        Pattern p = Pattern.compile(regex);

        List<String> str = new LinkedList<>();
        HashMap<String, String> map = new HashMap<>();
        for (String s : inputstr) {
            str.add(s);
            Matcher m1 = p.matcher(s);
                while (m1.find()) {
                    String time = m1.group();
                    map.put(s, time);
                    break;
                }
        }        
        

//         5
// my/2019-01-01T09:00:01
// my/2019-01-01T09:00:01
// abc/2018-12-24T08:00:00/test/you
// 1/2018-12-24T08:00:00/test/Test1
// 123/2018-12-24T08:00:09/test/me


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // TODO Auto-generated method stub

                String time1 = map.get(s1);
                String time2 = map.get(s2);
                
                System.out.println("time1: " + time1);
                System.out.println("time2: " + time2);

                if (!time1.equals(time2)) {
                    int l1 = 0;
                    int l2 = 0;
                    for (int i = 0; i < time1.length(); i++) {
                        l1 += time1.charAt(i);
                        l2 += time2.charAt(i);
                    }
                    return (int)(l1 - l2);
                }
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                if (s1.charAt(0) != s2.charAt(0)) {
                    return s1.charAt(0) - s2.charAt(0);
                }                
                return 0;
            }
        };
        
        Collections.sort(str, comparator);

        for (int i = 0; i < n; i++) {
            System.out.println(str.get(i));
        }       
        
    }
}
