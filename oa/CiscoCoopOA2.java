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

    public static void main(String[] args) {
        int numX = 20;
        int numY = 5;
        int res = getNum(numX, numY);
        System.out.println(res);
    }
}
