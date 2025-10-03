import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, honeys[], prefix[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        honeys = new int[N+1];
        prefix = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1] + honeys[i];
        }

        long answer = 0;


        // 1. [벌][벌통][벌] : 꿀통이 가운데
        for (int i = 2; i <= N-1; i++) {
            long sum = (prefix[i] - prefix[1])   // 왼쪽 벌이 채집
                    + (prefix[N-1] - prefix[i-1]); // 오른쪽 벌이 채집
            answer = Math.max(answer, sum);
        }

        // 2. [벌][벌][벌통] : 꿀통이 맨 끝 (오른쪽)
        for (int i = 2; i <= N; i++) {
            long sum = (prefix[N] - honeys[1] - honeys[i]) // 왼쪽 벌 시작
                    + (prefix[N] - prefix[i]);            // 오른쪽 벌 시작
            answer = Math.max(answer, sum);
        }

        // 3. [벌통][벌][벌] : 꿀통이 맨 끝 (왼쪽)
        for (int i = 1; i < N; i++) {
            long sum = (prefix[N-1] - honeys[i])  // 오른쪽 벌 시작
                    + (prefix[i-1]);            // 왼쪽 벌 시작
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
