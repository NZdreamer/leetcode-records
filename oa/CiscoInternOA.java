
public class CiscoInternOA {
    public static String[] isWordPresent(char[][] letters, String[] words) {
        String[] answers = new String[100];
        int rows = letters.length;
        int cols = letters[0].length;
        // HashMap<Character, String> map = new HashMap<>();
        // for (String word : words) {
        //     map.put(word.charAt(0), word);
        // }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < words.length; k++) {
                    boolean res = false;
                    if (find(letters, i, j, 0, 1, words[k])) res = true;
                    else if (find(letters, i, j, 0, -1, words[k])) res = true;
                    else if (find(letters, i, j, 1, 0, words[k])) res = true;
                    else if (find(letters, i, j, -1, 0, words[k])) res = true;
                    else res = false;
                    if (res) answers[k] = "YES";
                    else answers[k] = "NO";
                }
            }
        }
        return answers;
    }

    public static boolean find(char[][] letters, int i, int j, int dx, int dy, String s) {
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) != letters[i + dx * idx][j + dy * idx]) return false;
        }
        return true;
    }
}
