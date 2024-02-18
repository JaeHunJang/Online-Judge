import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T, N, count;
	public static void main(String[] args) throws Exception {
		init();
//		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken()); // 노드의 개수

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			combi(0);
			sb.append(count).append("\n");
		}
	}
	
	private static void combi(int sum) {
		if (sum > N) return;
		if (sum == N) {
			count++;
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			combi(sum+i);
		}
	}
}