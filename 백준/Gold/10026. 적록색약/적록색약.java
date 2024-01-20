import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static String[][] map;
	private static boolean[][] visited;
	private static boolean[][] visited2;
	private static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};
	private static final String[] RGB = { "R", "G", "B" };
	private static final String[] RGB2 = { "RG", "B" };
    
	private static int count;
	public static void main(String[] args) throws Exception {
		init();
		
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		map = new String[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (String color : br.readLine().split("")) {
				map[i][j++] = color;
			}
		}
		solve();
	}
	

	private static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < RGB.length; k++) {
					if (map[i][j].equals(RGB[k]) && !visited[i][j]) {					
						count++;
						visited[i][j] = true;
						dfs(i, j, RGB[k], visited);
					}
				}
			}
		}
		sb.append(count).append(" ");
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < RGB2.length; k++) {
					if (RGB2[k].contains(map[i][j]) && !visited2[i][j]) {					
						count++;
						visited2[i][j] = true;
						dfs(i, j, RGB2[k], visited2);
					}
				}
			}
		}
		sb.append(count);
	}
	
	private static void dfs(int i, int j, String color, boolean[][] visited) {
		for (int d = 0; d < deltas.length; d++) {
			int ni = i + deltas[d][0];
			int nj = j + deltas[d][1];
			
			if (ni >= 0 && ni < N && nj >= 0 && nj < N)	{
				if (color.contains(map[ni][nj]) && !visited[ni][nj]) {
					visited[ni][nj] = true;
					dfs(ni, nj, color, visited);
				}
			}
		}
	}
}