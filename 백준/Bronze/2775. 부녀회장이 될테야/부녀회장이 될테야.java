import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T;
	private static int k;
	private static int n;
	private static int[][] dp;
	private static final int MAX_LEN = 15;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		T = Integer.parseInt(br.readLine());
		dp = new int[MAX_LEN][MAX_LEN];
		
		for (int j = 1; j < MAX_LEN; j++) {
			dp[0][j] = j;
		}
		
		for (int i = 1; i < MAX_LEN; i++) {
			for (int j = 1; j < MAX_LEN; j++) {
				dp[i][j] = calc(i, j);
			}
		}
	}

	private static void solve() throws Exception {
		for (int i = 0; i < T; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n]+"\n");
		}
	}
	
	private static int calc(int i, int j) {
		i--;
		int sum = 0;
		for (int k = 1; k <= j; k++) {
			sum += dp[i][k];
		}
		return sum;
	}
}