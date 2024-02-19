import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, count;
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
		count = Integer.MAX_VALUE;
	}
	
	private static void solve() {
		recursive(N, 0);
		sb.append(count);
	}
	
	private static void recursive(int result, int cnt) {
		if (cnt > count) return;
		if (result < 1) return;
		
		if (result == 1) {
			count = Math.min(cnt, count);
			return;
		}
		
		if (result % 3 == 0) recursive(result/3, cnt+1);
		if (result % 2 == 0) recursive(result/2, cnt+1);
		recursive(result-1, cnt+1);
	}
}