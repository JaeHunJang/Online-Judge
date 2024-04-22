import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static char map[][];
	static int N, deltas[][] = {{-1, 0}, {1,0}, {0,-1},{0, 1}};
	static Train start, end;
	
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}

		@Override
		public boolean equals(Object obj) {
			Pos other = (Pos) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
		
	}
	
	static class Train {
		Pos s, m, e;

		public Train(Pos s, Pos m, Pos e) {
			this.s = s;
			this.m = m;
			this.e = e;
		}

		@Override
		public String toString() {
			return "Train [s=" + s + ", m=" + m + ", e=" + e + ", isRow=" + isRow() + "]";
		}
		
		public int isRow() {
			if (s.r == m.r) {
				return 0; // 가로
			} else {
				return 1; // 세로
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
//			System.out.println(Arrays.toString(map[i]));
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (start == null && map[i][j] == 'B') {
					Pos s = new Pos(i, j);
					if (i+1 < N && map[i+1][j] == 'B') {
						start = new Train(s, new Pos(i+1, j), new Pos(i+2, j));
					} else if (j+1 < N && map[i][j+1] == 'B') {
						start = new Train(s, new Pos(i, j+1), new Pos(i, j+2));
					}
				}
				if (end == null && map[i][j] == 'E') {
					Pos s = new Pos(i, j);
					if (i+1 < N && map[i+1][j] == 'E') {
						end = new Train(s, new Pos(i+1, j), new Pos(i+2, j));
					} else if (j+1 < N && map[i][j+1] == 'E') {
						end = new Train(s, new Pos(i, j+1), new Pos(i, j+2));
					}
				}
			}
		}
		
		
//		System.out.println(start);
//		System.out.println(end);
		
		solve();
		
		System.out.println(sb.toString());
	}
	
	static void solve() {
		Queue<Train> q = new ArrayDeque<>();
		q.offer(start);
		boolean visited[][][] = new boolean[2][N][N];
		visited[start.isRow()][start.m.r][start.m.c] = true;
		
		int count = 0;
		while(!q.isEmpty()) {
			int size = q.size();

			for (int s = 0; s < size; s++) {
				Train cur = q.poll();
				
//				System.out.println(count + "||" +cur);
//				printArr(visited);
				
				if (cur.s.equals(end.s) && cur.m.equals(end.m) && cur.e.equals(end.e)) {
					sb.append(count);
					return;
				}
				
				for (int d = 0; d < deltas.length; d++) {
					int snr = cur.s.r + deltas[d][0];
					int snc = cur.s.c + deltas[d][1];
					int mnr = cur.m.r + deltas[d][0];
					int mnc = cur.m.c + deltas[d][1];
					int enr = cur.e.r + deltas[d][0];
					int enc = cur.e.c + deltas[d][1];
					if (!isIn(snr, snc) || !isIn(mnr, mnc) || !isIn(enr, enc)) continue;
					if (visited[cur.isRow()][mnr][mnc]) continue;
					
					Train next = new Train(new Pos(snr, snc), new Pos(mnr, mnc), new Pos(enr, enc));
					if (!isMove(next)) continue;
						
					visited[cur.isRow()][mnr][mnc] = true;
					
					q.offer(next);
				}
				if (isRotate(cur)) {
					Train next = rotate(cur);
					if (visited[next.isRow()][next.m.r][next.m.c]) continue;
					visited[next.isRow()][next.m.r][next.m.c] = true;
//					System.out.println("회전해서 넣음");
					q.offer(next);
				} else {
//					System.out.println("회전해서 못넣음");
				}
			}
			
			count++;
		}
		
		sb.append(0);
	}
	
	static Train rotate(Train cur) {
		if (cur.isRow() == 0) {
//			cur.s.r = cur.m.r - 1;
//			cur.s.c = cur.m.c;
//			cur.e.r = cur.m.r + 1;
//			cur.e.c = cur.m.c;
			return new Train(new Pos(cur.m.r - 1, cur.m.c), cur.m, new Pos(cur.m.r + 1, cur.m.c));
		} else {
//			cur.s.r = cur.m.r;
//			cur.s.c = cur.m.c - 1;
//			cur.e.r = cur.m.r;
//			cur.e.c = cur.m.c + 1;
			return new Train(new Pos(cur.m.r, cur.m.c-1), cur.m, new Pos(cur.m.r, cur.m.c+1));
		}
	}
	
	static boolean isRotate(Train next) {
		int start, end;
		if (next.isRow() == 0) {
			start = 0;
			end = 1;
		} else {
			start = 2;
			end = 3;
		}
		
		for (int d = start; d <= end; d++) {
			int snc = next.s.c + deltas[d][1];
			int mnr = next.m.r + deltas[d][0];
			int snr = next.s.r + deltas[d][0];
			int mnc = next.m.c + deltas[d][1];
			int enr = next.e.r + deltas[d][0];
			int enc = next.e.c + deltas[d][1];
			if (!isIn(snr, snc) || !isIn(mnr, mnc) || !isIn(enr, enc)) return false;
			Train rotate = new Train(new Pos(snr, snc), new Pos(mnr, mnc), new Pos(enr, enc));
//			System.out.println("rotate : " + rotate);
			if (!isMove(rotate)) {
//				System.out.println("회전 불가");
				return false; 
			}
		}
		
		return true;
	}
	
	static boolean isMove(Train next) {
		if (map[next.s.r][next.s.c] == '1' || map[next.m.r][next.m.c] == '1' || map[next.e.r][next.e.c] == '1')
			return false;
		
		return true;
	}
	
	static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
	
	static void printArr(boolean[][][] visited) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				System.out.println(Arrays.toString(visited[i][j]));
			}
			System.out.println("---------------------");
		}
		System.out.println();
	}
}
