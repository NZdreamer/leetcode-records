public class CiscoCoopOA2 {
    public static int getNum(int numX, int numY) {
        int digitSum = 0;
        int res = 0;
        for (int i = 0; i <= numX; i++) {
            int cur = i;
            while (cur != 0) {
                digitSum += cur % 10;
                cur = cur / 10;
            }
            if (digitSum == numY) {
                res++;
            }
            digitSum = 0;
        }
        return res;
    }

    // public static int countRec(int n, int sum) {
    //     if (n == 0) {
    //         return sum == 0 ? 1 : 0;
    //     }
    //     int ans = 0;
    //     for (int i = 0; i < 9; i++) {
    //         if (sum - i >= 0) {
    //             ans += countRec(n - 1, sum - i);
    //         }
    //     }
    //     return ans;
    // }

    // public static int finalCount(int n, int sum) {
    //     int ans = 0;
    //     for (int i = 1; i < 9; i++) {
    //         if (sum - i > 0) {
    //             ans += countRec(n - 1, sum - i);
    //         }
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        int numX = 20;
        int numY = 5;
        int res = getNum(numX, numY);
        // int res = finalCount(3, numY);
        System.out.println(res);
    }
}
