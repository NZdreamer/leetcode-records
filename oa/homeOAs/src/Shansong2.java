import java.util.Scanner;

public class Shansong2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String[] nodes = input.substring(1, input.length() - 1).split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = nodes.length - 1; i < 0; i--) {
            sb.append(nodes[i]).append(",");
        }
        sb.append(nodes[0]).append("}");
        System.out.println(sb.toString());
    }

}
