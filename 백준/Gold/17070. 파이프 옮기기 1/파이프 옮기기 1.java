import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, count, map[][];
	static int deltas[][] = {{0, 1}, {1, 0}, {1, 1}};
	static class Pipe {
		int sr, sc, er, ec;

		public Pipe(int sr, int sc, int er, int ec) {
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 집 크기
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void solve() throws Exception {
		dfs(new Pipe(0, 0, 0, 1));
		sb.append(count);
	}
	
	private static void dfs(Pipe pipe) {
		if (pipe.er == N-1 && pipe.ec == N-1) { // 파이프 끝이 도착
			count++;
			return;
		}
		
		int dir = nowMoveDir(pipe);
		if (dir == 0) {
			if (isMoveW(pipe)) dfs(new Pipe(pipe.er, pipe.ec, pipe.er+deltas[0][0], pipe.ec+deltas[0][1]));
			if (isMoveX(pipe)) dfs(new Pipe(pipe.er, pipe.ec, pipe.er+deltas[2][0], pipe.ec+deltas[2][1]));
		} else if (dir == 1) {
			if (isMoveH(pipe)) dfs(new Pipe(pipe.er, pipe.ec, pipe.er+deltas[1][0], pipe.ec+deltas[1][1]));
			if (isMoveX(pipe)) dfs(new Pipe(pipe.er, pipe.ec, pipe.er+deltas[2][0], pipe.ec+deltas[2][1]));
		} else {
			if (isMoveW(pipe)) dfs(new Pipe(pipe.er, pipe.ec, pipe.er+deltas[0][0], pipe.ec+deltas[0][1]));
			if (isMoveH(pipe)) dfs(new Pipe(pipe.er, pipe.ec, pipe.er+deltas[1][0], pipe.ec+deltas[1][1]));
			if (isMoveX(pipe)) dfs(new Pipe(pipe.er, pipe.ec, pipe.er+deltas[2][0], pipe.ec+deltas[2][1]));
		}
	}
	
	private static int nowMoveDir(Pipe pipe) {
		if (pipe.er == pipe.sr) return 0; // 가로로 이동
		if (pipe.ec == pipe.sc) return 1; // 세로로 이동
		return 2; // 대각선 이동
	}
	
	private static boolean isMoveW(Pipe pipe) {
		int nr = pipe.er + deltas[0][0];
		int nc = pipe.ec + deltas[0][1];
		if (isIn(nr, nc) && map[nr][nc] == 0) return true;
		return false;
	}
	
	private static boolean isMoveH(Pipe pipe) {
		int nr = pipe.er + deltas[1][0];
		int nc = pipe.ec + deltas[1][1];
		if (isIn(nr, nc) && map[nr][nc] == 0) return true;
		return false;
	}
	
	private static boolean isMoveX(Pipe pipe) {
		int nr = pipe.er + deltas[2][0];
		int nc = pipe.ec + deltas[2][1];
		if (isIn(nr, nc) && map[nr][nc] == 0 && isMoveH(pipe) && isMoveW(pipe)) return true;
		return false;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}