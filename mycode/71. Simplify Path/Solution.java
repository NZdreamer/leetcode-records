class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> s = new Stack();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("..")) {
                if (!s.isEmpty()) s.pop();
            }
            else if (!(paths[i].equals("") || paths[i].equals("."))) {
                s.push(paths[i]);
            }
        }
        if (s.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.insert(0, s.pop());
            sb.insert(0, '/');
        }
        return sb.toString();
    }
}


//class Solution {
//    public String simplifyPath(String path) {
//        Stack<String> s = new Stack();
//        StringBuilder sb = new StringBuilder();
//        path += "/";
//        for (int i = 0; i < path.length(); i++) {
//            Character c = path.charAt(i);
//            if (c == '/') {
//                if (sb.length() != 0) {
//                    if (sb.toString().equals("..")) {
//                        if (!s.isEmpty()) s.pop();
//                    }
//                    else if (!sb.toString().equals(".")) {
//                        s.push(sb.toString());
//                    }
//                    sb.delete(0, sb.length());
//                }
//            }
//            else {
//                sb.append(c);
//            }
//        }
//        StringBuilder res = new StringBuilder();
//        if (s.isEmpty()) {
//            res.append('/');
//        }
//        while(!s.isEmpty()) {
//            res.insert(0, s.pop());
//            res.insert(0, '/');
//        }
//        return res.toString();
//    }
//}