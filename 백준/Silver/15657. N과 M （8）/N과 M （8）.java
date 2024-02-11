import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, result[], input[];
	private static boolean visited[];
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
		visited = new boolean[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
	}
	
	private static void solve() {
		combination(0, 0);
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == M) {
			printArr();
			return;
		}
		
		for (int i = start; i < N; i++) {
			result[cnt] = input[i];
			combination(cnt+1, i);
		}
	}
	
	private static void printArr() {
		for (int i = 0; i < M; i++) {
			sb.append(result[i]).append(" ");
		}
		sb.append("\n");
	}
}