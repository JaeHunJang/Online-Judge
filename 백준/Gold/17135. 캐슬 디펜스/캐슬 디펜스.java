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
	}
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, D, map[][], killCount,  rangerPos[], nowKill;
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
		int[][] copyMap = copyArr(map); // 궁수 위치별로 찾아야하기 때문에 맵 복사 진행
		nowKill = 0;
		for (int i = 0; i < N; i++) {
			killEnermy(copyMap);
			copyMap = moveDown(copyMap);
		}
		// 최다 킬 저장
		killCount = Math.max(nowKill, killCount);
	}
	
	private static void killEnermy(int[][] map) {
		List<Enemy> list = new ArrayList<>();
		for (int p = 0; p < rangerPos.length; p++) {
			initVisited();
			if (map[N-1][rangerPos[p]] == 1) { // 제일 가까이 있는 첫 위치
				list.add(new Enemy(N-1, rangerPos[p]));
			} else {
				Queue<Enemy> q = new ArrayDeque<>(); // 없으면 bfs로 순회
				q.offer(new Enemy(N-1, rangerPos[p]));
				visited[N-1][rangerPos[p]] = true; // 방문처리
				a:while(!q.isEmpty()) { // 궁수의 사거리 내에서 적 찾기
					Enemy current = q.poll();
					for (int d = 0; d < deltas.length; d++) {
						int nr = current.r + deltas[d][0]; 
						int nc = current.c + deltas[d][1];
						if (!isIn(nr, nc)) continue;
						int distance = inRange(nr, nc, N, rangerPos[p]);
						if (distance <= D) {
							if (map[nr][nc] == 1) { // 사거리 내에 적이 있으면 적 위치정보 저장
								for (Enemy e : list) {
									if (e.r == nr && e.c == nc) { // 같은 적을 때릴 수 있어서 동일한 적이면 저장하지 않고 탈출
										break a;
									}
								}
								list.add(new Enemy(nr, nc)); // 한번도 안때렸으면 저장하고 탈출
								break a;
							} else {
								Enemy next = new Enemy(nr, nc); // 적을 못찾으면 다음 순회
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
		// 찾은 적들 카운팅
		for (Enemy e : list) {
			if (map[e.r][e.c] == 1) {
				map[e.r][e.c] = 0;
				nowKill++;
			}
		}
	}
	// 2차원배열 복사 함수
	private static int[][] copyArr(int[][] arr) {
		int[][] copy = new int[arr.length][];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = arr[i].clone();
		}
		return copy;
	}
	
	// 맵 유효범위 확인 함수
	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	// 방문배열 초기화 함수
	private static void initVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	// 적들 1칸 아래로 이동시키는 함수
	private static int[][] moveDown(int[][] map) {
		for (int i = N-1; i >= 1; i--) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		Arrays.fill(map[0], 0);
		return map;
	}
	
	// 적과 궁수 사이 거리 계산 함수
	private static int inRange(int r, int c, int rangerR, int rangerC) {
		return Math.abs(rangerR - r) + Math.abs(rangerC - c);
	}
	
	// 궁수 위치 조합 만들기 함수
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