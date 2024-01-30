
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int M;
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
	}
	
	private static void solve() {
		permutation(N, M, new int[N], new boolean[N], 0); // 순열 함수 호출
	}
	/**
	 * @param n 전체 대상
	 * @param r 뽑을 개수
	 * @param nums 만들어낸 순열 저장 자료구조
	 * @param visited 전체 대상 중 이미 뽑은 대상 확인
	 * @param count 현재까지 전체 대상 중 뽑은 개수
	 */
	private static void permutation(int n, int r, int[] nums, boolean[] visited, int count) {
		if (count == r) { // 기저조건: 뽑을 개수만큼 뽑혔는지 확인
			for (int i = 0; i < r; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue; // 이미 뽑은 대상인지 확인
			nums[count] = i+1;
			visited[i] = true;
			permutation(n, r, nums, visited, count+1);
			visited[i] = false;
		}
	}
}