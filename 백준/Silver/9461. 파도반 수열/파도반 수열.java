import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

// 9461. 파도반 수열
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			BigDecimal[] dp = new BigDecimal[N+1]; // 큰 수 처리를 위한 BigDecimal
			dp[0] = new BigDecimal(0);
			if (N > 0) dp[1] = new BigDecimal(1); // N의 0 입력 처리
			if (N > 1) dp[2] = new BigDecimal(1); // N의 1 입력 처리
			
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i-3].add(dp[i-2]);
			}
			sb.append(dp[N].toString()).append("\n");
		}
		
	}
}