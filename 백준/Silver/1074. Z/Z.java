import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, r, c, count, result;
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
		N = Integer.parseInt(st.nextToken()); // 제곱수
		r = Integer.parseInt(st.nextToken()); // row
		c = Integer.parseInt(st.nextToken()); // col
		
		N = (int) Math.pow(2, N); // 배열 크기
		count = -1;
		result = -1;
	}
	
	private static void solve() throws Exception {
		search(N, 0, 0, N, N);
		sb.append(result);
	}
	
	private static void search(int n, int x1, int y1, int x2, int y2) {
		if (result != -1) return; // 목표값 찾았으면 재귀 종료
		// 목표값에 벗어나면 재귀를 호출하지 않고 count 증가
		if (r >= x1 && r < x2 && c >= y1 && c < y2) {
			if (n/2 > 1) { // 최소 크기까지 재귀 진행
				int half = n/2; // 4등분
				search(half, x1, y1, x2-half, y2-half);
				search(half, x1, y1+half, x2-half, y2);
				search(half, x1+half, y1, x2, y2-half);
				search(half, x1+half, y1+half, x2, y2);
			} else { // 값 채워넣기
				for (int i = x1; i < x2; i++) {
					for (int j = y1; j < y2; j++) {
						count++;
						if (i == r && j == c) {
							result = count;
							return;
						}
					}
				}
			}
		} else {
			count += (x2-x1) * (y2-y1);
		}
	}
}