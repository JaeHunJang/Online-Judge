import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int M;
	private static int depth;
	private static int count;
	private static String[][] map;
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
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		count = Integer.parseInt(st.nextToken()); // 회전 회수
		depth = Math.min(N,M) / 2; // 재귀 호출 횟수
		
		map = new String[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = st.nextToken();
			}
		}
	}
	
	private static void solve() {
		rotate(1,1,N,M,count,1);
		printArr();
	}
	
	/**
	 * 1칸씩 회전하는 함수
	 * @param x 배열을 회전시킬 첫번재 index
	 * @param y 배열을 회전시킬 첫번재 index
	 * @param N 배열을 회전시킬 크기
	 * @param M 배열을 회전시킬 크기
	 * @param count 배열을 회전시킬 횟수
	 * @param d 재귀 호출 횟수
	 */
	private static void rotate(int x, int y, int N, int M, int count, int d) {
		int i = x, j = y;
		String temp = ""; // 이전 칸 원소
		String temp2 = ""; // 다음 칸 원소
		for (int cnt = 0; cnt < count; cnt++) {
			temp = map[i][j];
			while (i < N) { // 아래로 한칸씩
				temp2 = map[++i][j];
				map[i][j] = temp;
				temp = temp2; // 다음칸 저장
			}
			temp = temp2; // 모서리 저장
			while (j < M) { // 오른쪽으로 한칸씩
				temp2 = map[i][++j];
				map[i][j] = temp;
				temp = temp2;
			}
			temp = temp2; // 모서리 저장
			while (i > x) { // 위로 한칸씩
				temp2 = map[--i][j];
				map[i][j] = temp;
				temp = temp2;
			}
			temp = temp2; // 모서리 저장
			while (j > y) { // 왼쪽으로 한칸씩
				temp2 = map[i][--j];
				map[i][j] = temp;
				temp = temp2;
			}
		}
		if (d < depth) {
			rotate(x+1, y+1, N-1, M-1, count, d+1);
		}
	}
	private static void printArr() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
}