import java.util.Arrays;

class Test1{
    public static int minimumKeypadCilckCount(String text) {
        char[] ca = text.toCharArray();
        // Map<Character, Integer> map = new HashMap<>((o1, o2) -> o2.value - o1.value);
        int[] input = new int[26];
        for (char c : ca) {
            input[c - 'a']++;
        }
        // Arrays.sort(input, (a, b) -> (b - a));
        Arrays.sort(input);

        // for (char c : ca) {
        //     map.put(c, map.getOrDefault(c, 0) + 1);
        // }
        int res = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            res += input[i] * ((25 - i) / 9 + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstvuwxyz";
        int res = minimumKeypadCilckCount(input);
        System.out.println(res);
    }
}