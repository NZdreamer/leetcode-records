import java.util.Scanner;

public class Meidi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        double[] l = new double[n];
        for (int i = 0; i < n; i++) {
            l[i] = in.nextDouble();
        }

        double maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += l[i];
        }
        double maxLen = maxSum / k;

        int num = 0;
        for (int i = 0; i < n; i++) {
            num += (int)(l[i] / maxLen);
        }
        if (num == k) {
            System.out.println(String.format("%.2f", maxLen));
            return;
        }
        int count = 0;
        while (count < k) {
            maxLen -= 0.01;
            count = 0;
            for (int i = 0; i < n; i++) {
                count += (int)(l[i] / maxLen);
            }
        }
        System.out.println(String.format("%.2f", maxLen));
        double aa = 8.04;
        double bb = 2.01;
        System.out.println((int)(aa/bb));

    }
}
