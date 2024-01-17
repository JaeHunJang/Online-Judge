import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static String S;
	private static String P;
	private static int result;
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(result);
	}	
	
	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine();
		result = 0;
		generateP();
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < M; i++) {
			if (S.substring(i).startsWith(P)) result++;
		}
	}
	
	private static void generateP() {
		for (int i = 0; i < N*2+1; i++) {
			if (i % 2 == 0)
				sb.append("I");
			else sb.append("O");
		}
		P = sb.toString();
		sb.setLength(0);
	}
}