import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int T;
	private static int N;
	private static int[][] map;
	private static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + "\n");
			
			N = Integer.parseInt(br.readLine()); //배열 크기
			map = new int[N][N];
			solve();
			printResult();
		}
	}
	
	private static void solve() {
		int i = 0;
		int j = 0;
		int cnt = 1;
		map[i][j] = cnt;
		while (cnt < N*N) {
			for (int d = 0; d < deltas.length; d++) {
				int nr = i + deltas[d][0];
				int nc = j + deltas[d][1];
				
				while (isIn(nr,nc) && map[nr][nc] == 0) {
					i = nr;
					j = nc;
					map[nr][nc] = ++cnt;
					nr += deltas[d][0];
					nc += deltas[d][1];
				}
			}
		}
	}
	
	private static void printResult() {
		for (int[] row : map) {
			for (int i : row) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
	}
	
	private static boolean isIn(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}
}