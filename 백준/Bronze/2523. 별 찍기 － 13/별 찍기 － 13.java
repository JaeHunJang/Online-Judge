import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static final String STAR = "*";
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		printResult();
	}
	private static void printResult() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
	}
	
	private static void solve() {
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j <= i; j++) {
				sb.append(STAR);
			}
			sb.append("\n");
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i; j++) {
				sb.append(STAR);
			}
			sb.append("\n");
		}
	}
}