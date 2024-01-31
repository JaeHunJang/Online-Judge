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
	private static int[][] dp;
	public static void main(String[] args) throws Exception {
		init2();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
		
	private static void init2() throws Exception { 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 전체 개수
		M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		dp = new int[N+1][N+1]; // 1 ~ N 까지의 합을 미리 저장할 배열
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				// 해당 자리 + 세로합 + 가로합 - 중복합
				dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
			}
		}
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < M; i++) { //구간합을 구할만큼 반복
			int[] subSet = Arrays.stream(br.readLine().split(" ")) // 구간 입력받기
					.mapToInt(Integer::parseInt)
					.toArray();
			sumSubSet2(subSet[0], subSet[1], subSet[2], subSet[3]);
		}
	}
	
	private static void sumSubSet2(int s1, int s2, int e1, int e2) {
		int sum = 0; // 구간합을 저장할 변수
		// 끝구간 - 왼쪽구간 - 위쪽구간 + (왼쪽과 위쪽 중복 구간합)
		sum = dp[e1][e2] - dp[e1][s2-1] - dp[s1-1][e2] + dp[s1-1][s2-1];
		sb.append(sum).append("\n"); // start ~ end 까지의 합 출력
	}
}