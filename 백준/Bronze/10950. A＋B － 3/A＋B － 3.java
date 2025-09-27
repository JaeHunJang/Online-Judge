import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int A;
	private static int B;
	public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
		    init();
		    solve();
        }
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}
	

	private static void solve() throws Exception {
		sb.append(A+B).append("\n");
	}
}
