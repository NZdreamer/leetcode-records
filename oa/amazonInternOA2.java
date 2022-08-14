import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class amazonInternOA2 {
    private static Map<String, String> passwordMap = new HashMap<>();
    private static Set<String> loggedIn = new HashSet<>();

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("register user05 qwerty");
        input.add("login user05 qwerty");
        input.add("logout user05");
        List<String> r = implementAPI(input);
        System.out.println(r);
    }

    public static List<String> implementAPI(List<String> logs) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] strs = logs.get(i).split(" ");
            if (strs[0] == "register") {
                if (passwordMap.containsKey(strs[1])) {
                    passwordMap.put(strs[1], strs[2]);
                    res.add(i, "Registered Successfully");
                }
                else {
                    res.add(i, "Username already exists");
                }
            }
            else if (strs[0] == "login") {
                if (passwordMap.get(strs[1]).equals(strs[2])) {
                    if (loggedIn.contains(strs[1])) {
                        res.add(i, "Login Unsuccessful");
                    }
                    else {
                        loggedIn.add(strs[1]);
                        res.add(i, "Logged In Successfully");
                    }                    
                }
                else {
                    res.add(i, "Login Unsuccessful");
                }
            }
            else if (strs[0] == "logout") {
                if (loggedIn.contains(strs[1])) {
                    loggedIn.remove(strs[1]);
                    res.add(i, "Logged Out Successfully");
                }
                else {
                    res.add(i, "Logout Unsuccessfully");
                }
            }
            
        }
        return res;

    }
}
