import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
	}

	private static void solve() throws Exception {
		int num = 666;
		int count = 0;
		while (count < N) {
			if ((num +"").contains("666")) {
				count++;
			}
			num++;
		}
		sb.append(num-1);
	}
}