import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, nums[], input[];
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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		nums = new int[M];

		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
	}

	

	private static void solve() {
		permutation(0, 0);
	}

	private static void permutation(int cnt, int start) {
		if (cnt == M) {
			printArr();
			return;
		}

		for (int i = start; i < N; i++) {
			nums[cnt] = input[i];
			permutation(cnt+1, i);
		}
	}

	private static void printArr() {
		for (int i = 0; i < M; i++) {
			sb.append(nums[i]).append(" ");
		}
		sb.append("\n");
	}
}