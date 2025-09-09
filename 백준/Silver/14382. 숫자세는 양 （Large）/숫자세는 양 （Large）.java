import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<Long> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("Case #").append(t).append(": ");
            set = new HashSet<>();
            long N = Integer.parseInt(br.readLine());
            if (N == 0) sb.append("INSOMNIA");
            else {
                int i = 1;
                while (true) {
                    getNum(N*i);
                    if (set.size() == 10) break;
                    i++;
                }
                sb.append(N*i);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void getNum(long num) {
        while (num > 0) {
            set.add(num % 10);
            num /= 10;
        }
    }
}
