import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2747. 피보나치 수 / 5분 
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		int dp[] = new int[N+1];
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		sb.append(dp[N]);
	}
}