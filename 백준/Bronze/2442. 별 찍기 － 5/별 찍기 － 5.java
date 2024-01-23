import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
	}

	private static void solve() throws Exception {
		for (int i = 1; i <= N; i++) {
			int j = 1;
			for (; j <= N-i; j++) {
				sb.append(" ");
			}
			for (j=1; j <= 2*i-1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
	}
}