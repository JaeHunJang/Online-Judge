import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int M;
	private static int[] input;
	private static int[] nums;
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
		N = Integer.parseInt(st.nextToken()); // 전체 대상
		M = Integer.parseInt(st.nextToken()); // 뽑을 개수
		
		input = new int[N]; // 전체 대상
		nums = new int[M]; // 뽑은 대상
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
	}
	
	private static void solve() {
		combination(0, 0);
	}
	
	/**
	 * @param cnt 뽑은 횟수
	 * @param start 지금까지 뽑은 idx
	 */
	private static void combination(int cnt, int start) {
		if (cnt == nums.length) { // nums.length == M == 뽑은 개수
			for (int num : nums) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < input.length; i++) { //input.length == N == 전체 대상
			nums[cnt] = input[i];
			combination(cnt+1, i+1); // i+1 현재 뽑은 수 다음부터 뽑기
		}
	}
}