import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static final int MOD = 10007;
    
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(countWays(N));
    }

    public static int countWays(int n) {
        // 초기 조건 설정
        if (n == 0) return 0; // 2×0 직사각형을 채울 수 없으므로 0 반환
        if (n == 1) return 1; // 2×1 직사각형을 채우는 방법은 1가지
        if (n == 2) return 3; // 2×2 직사각형을 채우는 방법은 3가지

        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 3;

        // 점화식을 사용하여 f(n) 계산
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i-1] + 2*f[i-2]) % MOD;
        }

        return f[n];
    }
}
