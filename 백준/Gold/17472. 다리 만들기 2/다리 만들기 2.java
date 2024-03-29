import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 17472. 다리 만들기 2 / 130분 
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M, parents[], deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	static char map[][];
	static PriorityQueue<Bridge> bridges;
	
	static class Pos {
		int r, c;
		char marker;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Pos(int r, int c, char marker) {
			this.r = r;
			this.c = c;
			this.marker = marker;
		}
	}
	
	static class Bridge {
		char from, to;
		int size;
		public Bridge(char from, char to, int size) {
			this.from = from;
			this.to = to;
			this.size = size;
		}
	}
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 섬 크기
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M]; // 섬
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		bridges = new PriorityQueue<>(new Comparator<Bridge>() {
			public int compare(Bridge o1, Bridge o2) {
				return Integer.compare(o1.size, o2.size);
			}
		});
		
		solve();
	}
		
	static void solve() throws Exception {
		findIsland(); // 어떤 섬인지 구분하기
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != '0') {
					buildBridge(new Pos(i, j, map[i][j])); // 섬마다 다리 건설하기
				}
			}
		}
		
		int size = 0;
		int cnt = 0;
		while(!bridges.isEmpty()) {
			Bridge b = bridges.poll();
			if (b.size <= 1) continue;
			if (union(b.from-'A', b.to-'A')) {
				size+= b.size;
				cnt++;
			}
		}
		if (cnt != parents.length-1) size = -1; // 못 만든 경우
		
		sb.append(size);
	}
	
	static int find(int a) { // 크루스칼 - find
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) { // 크루스칼 - union
		int pa = find(a), pb = find(b);
		if (pa == pb) return false;
		parents[pa] = pb;
		return true;
	}
	
	static void findIsland() {
		char marker = 'A';
		boolean visited[][] = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '1') {
					Queue<Pos> q = new ArrayDeque<>();
					q.offer(new Pos(i, j));
					visited[i][j] = true;
					map[i][j] = marker;
					
					while(!q.isEmpty()) {
						Pos cur = q.poll();
						
						for (int d = 0; d < deltas.length; d++) {
							int nr = cur.r + deltas[d][0];
							int nc = cur.c + deltas[d][1];
							
							if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
							if (map[nr][nc] == '0') continue;
							if (visited[nr][nc]) continue;
							visited[nr][nc] = true;
							map[nr][nc] = marker;
							q.offer(new Pos(nr, nc));
						}
					}
					marker++;
				}
			}
		}
		
		parents = new int[marker-'A']; // 찾은 섬의 개수로 배열 생성
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i; // 크루스칼 - make
		}
	}
	
	static void buildBridge(Pos cur) { 
		char marker = cur.marker; // 시작 섬
		for (int d = 0; d < deltas.length; d++) {
			int nr = cur.r;
			int nc = cur.c;
			int size = 0;
			while(true) {
				nr += deltas[d][0];
				nc += deltas[d][1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) break; // 범위 벗어나면 종료
				if (map[nr][nc] == marker) break; // 같은 섬 땅이면 종료
				if (map[nr][nc] != '0' && map[nr][nc] != marker) { // 바다도 같은 섬도 아니면 다리 건설
					bridges.offer(new Bridge(marker, map[nr][nc], size));
					break;
				}
				size++; // 다리 길이 증가
			}
		}
	}
	
	static void printArr(char map[][]) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(map[i]);
		}
		System.out.println();
	}
}