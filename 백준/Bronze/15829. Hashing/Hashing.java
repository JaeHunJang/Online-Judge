import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int T;
	private static char[] chars;
	private static long result;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		T = Integer.parseInt(br.readLine());
		result = 0;
		chars = br.readLine().toCharArray();
	}

	private static void solve() throws Exception {
		for (int i = 0; i < chars.length; i++) {
			result += (chars[i] - 96) * Math.pow(31, i);
		}
		sb.append(result);
	}
	
}