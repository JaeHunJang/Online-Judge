import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, map[][], deltas[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	static class Pos {
		int r, c, w;

		public Pos(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", w=" + w + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 동굴의 크기
		
		int tc = 1;
		while (N != 0) {// 0이면 종료
			map = new int[N][N]; // 동굴
			sb.append("Problem ").append(tc++).append(": ");
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			solve();
			
			N = Integer.parseInt(br.readLine());
		}
	}
	
	static void solve() throws Exception {
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {
			public int compare(Pos o1, Pos o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});
		pq.offer(new Pos(0, 0, map[0][0]));
		int visited[][] = new int[N][N];
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		visited[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			
			if (cur.r == N-1 && cur.c == N-1) {
				sb.append(cur.w).append("\n");
				return;
			}
			for (int d = 0; d < deltas.length; d++) {
				int nr = deltas[d][0] + cur.r;
				int nc = deltas[d][1] + cur.c;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc] <= cur.w + map[nr][nc]) continue;
				visited[nr][nc] = cur.w + map[nr][nc];
				pq.offer(new Pos(nr, nc, visited[nr][nc]));
			}
		}
	}
	
}