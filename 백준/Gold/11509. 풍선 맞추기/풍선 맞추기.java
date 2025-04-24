import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, balloons[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        balloons = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int[] arrows = new int[1_000_001];
        for (int i = 0; i < N; i++) {
            if (arrows[balloons[i]] > 0) {
                arrows[balloons[i]]--;
            } else {
                cnt++;
            }
            arrows[balloons[i]-1]++;
        }
        
        System.out.println(cnt);
    }
}