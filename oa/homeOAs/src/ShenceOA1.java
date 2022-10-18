import java.util.Scanner;

public class ShenceOA1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(convertIpv7(sc.nextLine()));
        }
    }

    public static long convertIpv7(String ip) {
        String[] ips = ip.split("\\.");
        if (ips.length != 7) {
            return -1;
        }
        if (ips[0].length() == 0 || ips[6].length() == 0) return -1;

        long[] ipsInt = new long[ips.length];
        for (int i = 0; i < ips.length; i++) {
            long t = 0;
            if (ips[i].length() != 0) {
                try {
                    t = Long.valueOf(ips[i]);
                }
                catch (NumberFormatException e) {
                    return -1;
                }
                if (t < 0 || t > 255) return -1;
            }
            ipsInt[i] = t;
        }
        if (ipsInt[0] == 0) return -1;

        long base = 1, res = 0;
        for (int i = ipsInt.length - 1; i >= 0; i--) {
            res += ipsInt[i] * base;
            base *= 256;
        }
        return res;
    }
}
