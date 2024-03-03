import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, map[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 보급로 맵 크기  
			
			visited = new boolean[N][N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				int j = 0;
				for (String s : br.readLine().split("")) {
					map[i][j++] = Integer.parseInt(s);
				}
			}

			solve();
		}
	}
	
	private static void solve() throws Exception {
		int deltas[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() { // 거리 탐색을 단축하기 위해 pq 사용
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		q.offer(new int[] {0, 0, 0});
		visited[0][0] = true;
		
		int result = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			
			if (cur[0] == N-1 && cur[1] == N-1) {
				result = Math.min(result, cur[2]);
				break;
			}
			
			for (int d = 0; d < deltas.length; d++) {
				int nr = cur[0] + deltas[d][0];
				int nc = cur[1] + deltas[d][1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, cur[2] + map[nr][nc]});
			}
		}
		sb.append(result).append("\n");
	}
}
