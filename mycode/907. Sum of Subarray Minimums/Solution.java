class Solution {
    public int sumSubarrayMins(int[] arr) {
        long mod = (long)1e9 + 7;
        int[] cntr = new int[arr.length];
        int[] cntl = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            cntr[i] = 0;
            cntl[i] = 0;
        }
        Stack<Integer> s = new Stack(); // index of arr

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] < arr[s.peek()]) {
                int tmp = s.pop();
                cntr[tmp] = i - tmp;
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int tmp = s.pop();
            cntr[tmp] = arr.length - tmp;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                int tmp = s.pop();
                cntl[tmp] = tmp - i;
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int tmp = s.pop();
            cntl[tmp] = tmp + 1;
        }

        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = (res + (long)cntr[i] * cntl[i] * arr[i]) % mod;
        }
        return (int)res;
    }
}