import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 2293. 동전 1 / 90분 
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, K, cnt, coins[];
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int dp[] = new int[K+1]; // dp 배열은 각 index가 k원를 나타내며 k원을 만들 수 있는 경우의 수를 저장
		dp[0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int k = coins[i]; k <= K; k++) {
				dp[k] += dp[k-coins[i]]; 
			}
		}
		
		sb.append(dp[K]);
	}

}