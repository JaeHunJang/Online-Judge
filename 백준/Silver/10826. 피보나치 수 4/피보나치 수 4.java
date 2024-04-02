import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

// 10826. 피보나치 수 4 / 15분 
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
		
		BigDecimal[] dp = new BigDecimal[N+1];
		dp[0] = new BigDecimal(0);
		if (N > 0) dp[1] = new BigDecimal(1);
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-2].add(dp[i-1]);
		}
		
		sb.append(dp[N].toString());
	}
}