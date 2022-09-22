
import java.util.Arrays;
import java.util.Scanner;

public class Meidi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < n; i++) {
            y[i] = in.nextInt();
        }

        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = x[i];
            points[i][1] = y[i];
        }

        Arrays.sort(points, (o1, o2) -> (o1[0] - o2[0]));
        double min = Double.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            double dist = Math.pow(points[i][0] - points[i - 1][0], 2) + Math.pow(points[i][1] - points[i - 1][1], 2);
            min = Math.min(Math.sqrt(dist), min);
        }
        Arrays.sort(points, (o1, o2) -> (o1[1] - o2[1]));
        for (int i = 1; i < n; i++) {
            double dist = Math.pow(points[i][0] - points[i - 1][0], 2) + Math.pow(points[i][1] - points[i - 1][1], 2);
            min = Math.min(Math.sqrt(dist), min);
        }

        System.out.println(String.format("%.4f", min));
    }
}

