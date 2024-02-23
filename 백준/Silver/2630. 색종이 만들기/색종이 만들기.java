import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, map[][], countWhite, countBlue;
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 종이 한 변의 길이
		map = new int[N][N];
		
		countWhite = 0;
		countBlue = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		sb.append("\n");
	}
	
	private static void solve() throws Exception {
		search(N, 0, 0, N, N);
		sb.append(countWhite).append("\n").append(countBlue);
	}
	
	private static void search(int N, int x1, int y1, int x2, int y2) {
		int color = searchAll(x1, y1, x2, y2);
		if (color != -1) { // 전부 같은 색종이면 재귀 종료
			if (color == 1) countBlue++;
			else countWhite++;
			return;
		}
		
		if (N > 1) {
			int half = N / 2;
			search(half, x1, y1, x2-half, y2-half);
			search(half, x1, y1+half, x2-half, y2);
			search(half, x1+half, y1, x2, y2-half);
			search(half, x1+half, y1+half, x2, y2);
		}
	}
	
	private static int searchAll(int x1, int y1, int x2, int y2) {
		int color = map[x1][y1];
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if (map[i][j] != color) {
					return -1;
				}
			}
		}
		return color;
	}
}
