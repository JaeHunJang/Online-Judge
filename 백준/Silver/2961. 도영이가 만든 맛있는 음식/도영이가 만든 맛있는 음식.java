import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int[][] input;
	private static int result;
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
		N = Integer.parseInt(st.nextToken()); // 재료 개수
		result = Integer.MAX_VALUE;
		input = new int[N][2]; // 맛
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void solve() {
		binaryCounting();
		sb.append(result);
	}
	
	private static void binaryCounting() {
		// i = 1 로 시작하여 공집합을 제외
		for (int i = 1; i < 1<<N; i++) {
			int mul = 1; // 신맛
			int sum = 0; // 쓴맛
			for (int j = 0; j < N; j++) {
				int idx = i & 1 << j;
				if (idx != 0) {
					mul *= input[j][0];
					sum += input[j][1];
				}
			}
			result = Math.min(result, Math.abs(sum-mul)); // 최소값 찾기
		}
	}
}