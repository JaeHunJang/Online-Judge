import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (sum + book <= M) {
                sum += book;
            } else {
                sum = book;
                cnt++;
            }
        }
        
        if (sum > 0) cnt++;
        System.out.println(cnt);
    }
}