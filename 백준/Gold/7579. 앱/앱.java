import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 앱
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static App apps[];
	
	static class App {
		int m, c;

		public App(int m, int c) {
			this.m = m;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // App 개수
		M = Integer.parseInt(st.nextToken()); // 얻어야 할 메모리
		apps = new App[N+1];
		apps[0] = new App(0, 0);
		
		st = new StringTokenizer(br.readLine()); // 앱별 사용중인 메모리
		for (int i = 1; i <= N; i++) {
			apps[i] = new App(0, 0);
			apps[i].m = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine()); // 앱별 비활성화 비용
		for (int i = 1; i <= N; i++) {
			apps[i].c = Integer.parseInt(st.nextToken());
		}

		solve();
	}
	
	static void solve() throws Exception {
		long minCost = Integer.MAX_VALUE; // 앱 비활성화 최소 비용
		int dp[][] = new int[N+1][10001];
		for (int i = 1; i <= N; i++) {
			for (int c = 0; c <= 10000; c++) {
				if (apps[i].c > c) {
					dp[i][c] = dp[i-1][c];
				} else {
					dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-apps[i].c] + apps[i].m);
				}
				if (dp[i][c] >= M) {
					minCost = Math.min(c, minCost);
				}
			}
		}
		sb.append(minCost);
	}
}