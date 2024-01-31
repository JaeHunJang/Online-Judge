import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int M;
	private static int[] dp;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 전체 개수
		M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		dp = new int[N+1]; // 1 ~ N 까지의 합을 미리 저장할 배열
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(st.nextToken()) + dp[i-1];
		}
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < M; i++) { //구간합을 구할만큼 반복
			int[] subSet = Arrays.stream(br.readLine().split(" ")) // 구간 입력받기
					.mapToInt(Integer::parseInt)
					.toArray();
			sumSubSet(subSet[0], subSet[1]);
		}
	}
	
	private static void sumSubSet(int start, int end) {
		int sum = dp[end] - dp[start-1]; // end 까지의 합에서 start 직전까지의 합 빼기  
		sb.append(sum).append("\n"); 
	}
}