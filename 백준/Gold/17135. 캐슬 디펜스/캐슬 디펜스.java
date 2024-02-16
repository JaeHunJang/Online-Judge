import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static class Enemy {
		int r, c;

		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Enemy [r=" + r + ", c=" + c + "]";
		}
		
		@Override
		public boolean equals(Object obj) {
			Enemy other = (Enemy) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
		
	}
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, D, map[][], killCount,  rangerPos[], nowKill, nowDistance;
	private static int deltas[][] = {{0, -1}, {-1, 0}, {0, 1}};
	private static boolean visited[][];
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
		N = Integer.parseInt(st.nextToken()); // 격자판 행
		M = Integer.parseInt(st.nextToken()); // 격자판 열
		D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리
		killCount = 0; // 죽인 적
		
		map = new int[N][M]; // 격자판
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		visited = new boolean[N][M];
		rangerPos = new int[3];
	}
	
	private static void solve() throws Exception {
		combiRangerPosition(0, 0);
		simulation();
		sb.append(killCount);
	}
	private static void simulation() {
		int[][] copyMap = copyArr(map);
		nowKill = 0;
		for (int i = 0; i < N; i++) {
			nowDistance = 1;
			killEnermy(copyMap);
			copyMap = moveDown(copyMap);
		}
		killCount = Math.max(nowKill, killCount);
	}
	
	private static void killEnermy(int[][] map) {
		List<Enemy> list = new ArrayList<>();
		for (int p = 0; p < rangerPos.length; p++) {
			initVisited();
			if (map[N-1][rangerPos[p]] == 1) { // 제일 가까이 있는 첫 위치
				list.add(new Enemy(N-1, rangerPos[p]));
			} else {
				Queue<Enemy> q = new ArrayDeque<>();
				q.offer(new Enemy(N-1, rangerPos[p]));
				visited[N-1][rangerPos[p]] = true;
				a:while(!q.isEmpty()) {
					Enemy current = q.poll();
					for (int d = 0; d < deltas.length; d++) {
						int nr = current.r + deltas[d][0]; 
						int nc = current.c + deltas[d][1];
						if (!isIn(nr, nc)) continue;
						int distance = inRange(nr, nc, N, rangerPos[p]);
						if (distance <= D) {
							if (map[nr][nc] == 1) {
								for (Enemy e : list) {
									if (e.r == nr && e.c == nc) {
										break a;
									}
								}
								list.add(new Enemy(nr, nc));
								break a;
							} else {
								Enemy next = new Enemy(nr, nc); 
								if (!visited[next.r][next.c]) {
									q.offer(next);
									visited[next.r][next.c] = true;
								}
							}
						}
					}
				}
			}
		}
		for (Enemy e : list) {
			if (map[e.r][e.c] == 1) {
				map[e.r][e.c] = 0;
				nowKill++;
			}
		}
	}
	
	private static int[][] copyArr(int[][] arr) {
		int[][] copy = new int[arr.length][];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = arr[i].clone();
		}
		return copy;
	}
	
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	private static void printMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	private static void initVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	private static int[][] moveDown(int[][] map) {
		for (int i = N-1; i >= 1; i--) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		Arrays.fill(map[0], 0);
		return map;
	}
	
	private static int inRange(int r, int c, int ranger) {
//		System.out.printf("%d %d %d %n", r, c, ranger);
		return Math.abs(N - r) + Math.abs(ranger - c);
	}
	
	private static int inRange(int r, int c, int rangerR, int rangerC) {
		return Math.abs(rangerR - r) + Math.abs(rangerC - c);
	}
	
	private static void combiRangerPosition(int cnt, int start) {
		if (cnt == 3) {
			simulation();
			return;
		}
		
		for (int i = start; i < M; i++) {
			rangerPos[cnt] = i;
			combiRangerPosition(cnt+1, i+1);
		}
	}
}