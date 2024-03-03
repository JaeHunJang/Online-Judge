import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, K, map[][], deltas[][] = {{1,0}, {-1,0}, {0,-1},{0,1}}, maxLen;
	static List<int[]> list;
	static int visited[][];
	
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
			N = Integer.parseInt(st.nextToken()); // 등산로 맵 크기  
			K = Integer.parseInt(st.nextToken()); // 봉우리 깎기 횟수
			maxLen = 0; // 등산로 거리
			list = new ArrayList<>();
			
			visited = new int[N][N];
			map = new int[N][N];
			int top = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (top < map[i][j]) {
						list.clear();
						top = map[i][j];
						list.add(new int[] {i, j}); // 제일 큰 봉우리만 담아둠
					} else if (top == map[i][j]) {
						list.add(new int[] {i, j});
					}
				}
			}

			solve();
		}
	}
	
	private static void solve() throws Exception {
		for (int[] start : list) {
			visited[start[0]][start[1]] = 1;
			dfs(1, start[0], start[1], K);
			visited[start[0]][start[1]] = 0;
		}
		
		sb.append(maxLen).append("\n");
	}
	
	private static void dfs(int cnt, int r, int c, int k) {
		maxLen = Math.max(cnt, maxLen);
		
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if (!isIn(nr, nc)) continue; 
			if (visited[nr][nc] > 0) continue;
			
			visited[nr][nc] = 1;
			if (map[r][c] > map[nr][nc]) { // 현재 봉우리보다 작으면 바로 감
				dfs(cnt+1, nr, nc, k);
			} else if (k > 0) { // 현재 봉우리보다 크면 깎을 수 있는지 보고 감
				for (int cut = 1; cut <= k; cut++) {
					if (map[r][c] > map[nr][nc] - cut) {
						map[nr][nc] -= cut;
						dfs(cnt+1, nr, nc, 0);
						map[nr][nc] += cut;
					}
				}
			}
            visited[nr][nc] = 0;
		}
	}
	
	private static void printArr() {
		for (int i = 0; i < visited.length; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		System.out.println();
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
