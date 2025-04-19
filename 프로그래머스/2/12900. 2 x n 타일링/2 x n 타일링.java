class Solution {
    int MOD = 1_000_000_007;
    public int solution(int n) {
        
        
        return countWays(n);
    }
    
    int countWays(int n) {
        // 초기 조건 설정
        if (n == 0) return 0; // 2×0 직사각형을 채울 수 없으므로 0 반환
        if (n == 1) return 1; // 2×1 직사각형을 채우는 방법은 1가지

        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;

        // 점화식을 사용하여 f(n) 계산
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i-1] + f[i-2]) % MOD;
        }

        return f[n];
    }
}