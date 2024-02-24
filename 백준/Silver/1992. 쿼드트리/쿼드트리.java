import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, map[][];
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
		N = Integer.parseInt(st.nextToken()); // 배열 크기
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
	}
	
	private static void solve() throws Exception {
		search(N, 0, 0, N, N);
	}
	
	private static void search(int n, int x1, int y1, int x2, int y2) {
		int bit = searchAll(x1, y1, x2, y2);
		if (bit != -1) { // 전부 같은 숫자면 재귀 종료
			sb.append(bit);
			return;
		}

		if (n > 1) { // 최소 크기까지 재귀 진행
			int half = n/2; // 4등분
			sb.append("(");
			search(half, x1, y1, x2-half, y2-half);
			search(half, x1, y1+half, x2-half, y2);
			search(half, x1+half, y1, x2, y2-half);
			search(half, x1+half, y1+half, x2, y2);
			sb.append(")");
		} 
	}
	
	private static int searchAll(int x1, int y1, int x2, int y2) {
		int bit = map[x1][y1];
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if (map[i][j] != bit) {
					return -1;
				}
			}
		}
		return bit;
	}
}