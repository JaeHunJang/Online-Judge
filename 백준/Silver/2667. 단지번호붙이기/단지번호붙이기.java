import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[][] map;
	private static int[][] visited;
	private static HashMap<Integer, Integer> result;
	private static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};
    
	private static int count;
	public static void main(String[] args) throws Exception {
		init();
		
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new int[N][N];
		result = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (String num : br.readLine().split("")) {
				map[i][j++] = Integer.parseInt(num);
			}
		}
		solve();
	}
	

	private static void solve() {
		int k = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {					
					count = 1;
					visited[i][j] = count;
					result.put(k++, dfs(i, j));
				}
			}
		}
		sb.append(result.size()).append("\n");
		for (int tmp : result.values().stream().sorted().collect(Collectors.toList()))
			sb.append(tmp).append("\n");
	}
	
	private static int dfs(int i, int j) {
		for (int d = 0; d < deltas.length; d++) {
			int ni = i + deltas[d][0];
			int nj = j + deltas[d][1];
			
			if (ni >= 0 && ni < N && nj >= 0 && nj < N)	{
				if (map[ni][nj] == 1 && visited[ni][nj] == 0) {
					visited[ni][nj] = ++count;
					dfs(ni, nj);
				}
			}
		}
		return count;
	}
}