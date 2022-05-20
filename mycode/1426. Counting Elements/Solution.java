class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet();
        int sum = 0;
        for (int a : arr) {
            set.add(a - 1);
        }
        for (int a : arr) {
            if (set.contains(a)) sum++;
        }
        return sum;
    }
}