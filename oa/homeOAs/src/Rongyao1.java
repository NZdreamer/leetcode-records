import java.util.Scanner;

public class Rongyao1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int ans=0;
        for(int i = 1; i < p / 3; i++){
            for(int j = i + 1; j < p / 2; j++){
                int k = p - i - j;
                if(k < i + j && i * i + j * j == k * k)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}