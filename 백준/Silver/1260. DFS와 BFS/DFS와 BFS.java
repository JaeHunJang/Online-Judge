import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, V, matrix[][];
	private static boolean visited[];
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
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		matrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
	}
	
	private static void solve() throws Exception {
		visited[V] = true; // 시작 노드 방문처리
		dfs(0, V);
		sb.append("\n");
		bfs(V);
	}
	
	private static void dfs(int cnt, int current) {
		if (cnt == N) {
			return;
		}
		
		sb.append(current).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if (matrix[current][i] != 0 && !visited[i]) {
				visited[i] = true;
				dfs(cnt+1, i);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited = new boolean[N+1]; // 방문처리 배열 초기화
		
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int current = q.poll();
			
			sb.append(current).append(" ");
			
			for (int i = 0; i <= N; i++) {
				if (matrix[current][i] != 0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}