import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, map[][], time, fish[], deltas[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static Shark shark;
	static boolean visited[][], callMom;
	
	static class Shark {
		int r, c, size, exp;

		public Shark(int r, int c) {
			this.r = r;
			this.c = c;
			size = 2;
			exp = 2;
		}
		public void eat() {
			if (--exp == 0)
				exp = ++size;
		}
	}
	static class Fish {
		int r, c, size, distance;

		public Fish(int r, int c, int size, int distance) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + ", distance=" + distance + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	
	static void print() {
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // map 크기
		time = 0; // 더이상 물고기를 먹을 수 없을때까지 이동한 시간
		fish = new int[7]; // 물고기가 몇마리 남았는지
		callMom = false; 
		
		visited = new boolean[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 시작점
					shark = new Shark(i, j);
					map[i][j] = 0;
				} else {
					fish[map[i][j]]++;
				}
			}
		}
		
		fish[0] = 0;
	}
	
	static void solve() throws Exception {
		while (!callMom) {
			bfs();
			initVisited();
		}
		sb.append(time);
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {shark.r, shark.c});
		visited[shark.r][shark.c] = true;

		PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {
			public int compare(Fish o1, Fish o2) {
				if (o1.r == o2.r) { // 위쪽에 있는 상어가 있으면
					return Integer.compare(o1.c, o2.c); // 왼쪽에 있는 상어
				}
				return Integer.compare(o1.r, o2.r);
			}
		});
		
		int distance = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			distance++;
			
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int d = 0; d < deltas.length; d++) {
					int nr = cur[0] + deltas[d][0];
					int nc = cur[1] + deltas[d][1];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (visited[nr][nc]) continue;
					if (map[nr][nc] > shark.size) continue;
					visited[nr][nc] = true;
					
					if (map[nr][nc] > 0 && map[nr][nc] < shark.size) { // 먹을 수 있는 물고기만 담기
						pq.offer(new Fish(nr, nc, map[nr][nc], distance));
					} else if (map[nr][nc] <= shark.size) {
						q.offer(new int[] {nr, nc});
					}
				}
			}
			
			if (!pq.isEmpty()) break;
		}
		
		if (!pq.isEmpty()) {
			Fish f = pq.poll();
			fish[f.size]--; // 먹은 물고기 개체수 줄이기
			map[f.r][f.c] = 0; // 물고기 없애기
			shark.r = f.r; // 상어 위치 이동
			shark.c = f.c; 
			shark.eat();
			time += f.distance; // 이동거리 더해주기
		} else {
			callMom = true;
		}
	}
	
	static void initVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static void printArr(int map[][]) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}