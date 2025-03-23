import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] num = new boolean[31];

        for (int i = 1; i <= 28; i++) {
            num[Integer.parseInt(br.readLine())] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!num[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}