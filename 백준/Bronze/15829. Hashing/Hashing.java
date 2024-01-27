import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int T;
	private static char[] chars;
	private static long result;
	private static final int MOD = 1234567891;
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
		long pow = 1;
		for (int i = 0; i < chars.length; i++) {
			result += (chars[i] - 96) * pow % MOD;
			pow = pow * 31 % MOD; 
		}
		sb.append(result % MOD);
	}
}