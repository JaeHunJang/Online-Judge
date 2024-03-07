import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 리모컨 - 3시간
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,  M, unBrokenNums[], count, len;

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(sb.toString());
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        count = Integer.MAX_VALUE;
        len = String.valueOf(N).length(); // 자리수 저장

        unBrokenNums = new int[10];
        for (int i = 0; i < 10; i++) {
            unBrokenNums[i] = i;
        }
        if (M > 0) { // 고장난 버튼이 있을 때
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                unBrokenNums[Integer.parseInt(st.nextToken())] = -1;
            }
        }

        solve();
    }

    private static void solve() throws Exception {
        if (N == 100) { // 100번 채널로 시작이므로 100이 들어오면 바로 처리
            sb.append(0);
            return;
        } else {
            count = Math.abs(100-N);
        }
        dfs(0, 0);

        sb.append(count);
    }

    private static void dfs(int cnt, int num) {
        for (int i = 0; i < 10; i++) {
            if (unBrokenNums[i] == -1) continue;
            int temp = num*10+i;
            count = Math.min(count, cnt+1 + (Math.abs(N - temp)));
            if (cnt < 6) {
                dfs(cnt+1, temp);
            }
        }
    }
}