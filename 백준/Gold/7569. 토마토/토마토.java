import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, H, map[][][], count, all;
	private static Queue<int[]> q;
	private static int deltas[][] = {{0, -1, 0}, {0, 1, 0}, {-1, 0, 0}, {1, 0, 0}, {0, 0, -1}, {0, 0, 1}};
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
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][M][N];
		q = new LinkedList<>();
		all = M*N*H;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if (map[k][i][j] == 1) {
						q.offer(new int[] {i, j, k});
						all--;
					}
					if (map[k][i][j] == -1) {
						all--;
					}
				}
			}
		}
		
		count = -1;
	}
	
	private static void solve() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now[] = q.poll();
				for (int d = 0; d < deltas.length; d++) {
					int nx = now[0] + deltas[d][0]; 
					int ny = now[1] + deltas[d][1];
					int nh = now[2] + deltas[d][2];
					if (!isIn(nx, ny, nh)) continue;
					if (map[nh][nx][ny] != 0) continue;
					map[nh][nx][ny] = 1;
					all--;
					q.offer(new int[] {nx, ny, nh});
				}
			}
			if (size > 0) count++;
		}
		if (all > 0) {
			sb.append("-1");
		} else 
			sb.append(count);
	}
	
	private static boolean isIn(int i, int j, int h) {
		return i >= 0 && i < M && j >= 0 && j < N && h >= 0 && h < H;
	}
}
