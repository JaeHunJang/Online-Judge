import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 1194. 달이 차오른다, 가자. / 분 
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M, deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static char map[][];
	
	static class Pos {
		int r, c, keys[], step, keyCount;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
			keys = new int[7];
			step = 0;
			keyCount = 0;
		}
		
		public void setKey(char k) {
			keys[k-'a'+1]++;
			keyCount = 0;
			for (int i = 0; i < keys.length; i++) {
				if (keys[i] > 0) keyCount |= 1<<i;
			}
		}
		
		public boolean hasKey(char k) {
			if (keys[k-'A'+1] > 0) return true;
			return false;
		}
		
		public void copyKey(int keys[]) {
			for (int i = 0; i < this.keys.length; i++) {
				this.keys[i] = keys[i];
			}
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", keys=" + Arrays.toString(keys) + ", step=" + step + ", keyCount="
					+ keyCount + "]";
		}

		
	}
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		map = new char[N][M];
		Pos start = null;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') start = new Pos(i,j); 
			}
		}

		solve(start);
	}
	
	static void solve(Pos start) throws Exception {
		/*PriorityQueue<Pos> q = new PriorityQueue<>(new Comparator<Pos>() {
			public int compare(Pos o1, Pos o2) {
				if (Integer.compare(o1.step, o2.step) == 0) return Integer.compare(o2.keyCount, o1.keyCount);
				return Integer.compare(o1.step, o2.step);
			}
		});*/
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(start);
		boolean visited[][][] = new boolean[1<<7][N][M];
//		start.setKey('a');
//		start.setKey('b');
//		start.setKey('c');
//		start.setKey('d');
//		start.setKey('e');
//		start.setKey('f');
//		System.out.println(start.keyCount);
		visited[start.keyCount][start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
//			System.out.println(cur);
			if (map[cur.r][cur.c] == '1') {
				sb.append(cur.step);
				return;
			}
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = cur.r + deltas[d][0];
				int nc = cur.c + deltas[d][1];
				
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;				
				if (map[nr][nc] == '#') continue;
				if (visited[cur.keyCount][nr][nc]) continue;
				if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F' && !cur.hasKey(map[nr][nc])) continue;
				visited[cur.keyCount][nr][nc] = true;
				
				Pos next = new Pos(nr,nc);
				next.copyKey(cur.keys);
				next.keyCount = cur.keyCount;
				next.step = cur.step+1;
				if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f' ) next.setKey(map[nr][nc]);
				q.offer(next);
			}
		}
		
		sb.append(-1);
	}
}