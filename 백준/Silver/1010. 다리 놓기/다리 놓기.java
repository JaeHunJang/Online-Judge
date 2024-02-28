import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T, N, M;
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
		T = Integer.parseInt(st.nextToken()); // 집 개수
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 서 사이트
			M = Integer.parseInt(st.nextToken()); // 동 사이트
			
			BigDecimal n = new BigDecimal(M+""); // n!
			for (int j = 2; j < M; j++) {
				n = n.multiply(new BigDecimal(j+""));
			}
			BigDecimal k = new BigDecimal(N+""); // k!
			for (int j = 2; j < N; j++) {
				k = k.multiply(new BigDecimal(j+""));
			}
			for (int j = 2; j <= M-N; j++) { // (n-k)!
				k = k.multiply(new BigDecimal(j+""));
			}
			System.out.println(n.divide(k).toString());
		}
	}
	
	private static void solve() throws Exception {
		
	}
}