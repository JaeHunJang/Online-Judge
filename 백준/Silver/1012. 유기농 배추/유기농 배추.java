import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < t; test_case++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] map = new int[m][n];
			int[][] dp = new int[m][n];
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			int count = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1 && dp[i][j] <= 0)  {
						visited(dp, map, i, j, ++count);
					}
				}
			}
			
			System.out.println(count);
		}
    }
	
	static void visited(int[][] dp, int[][] map, int x, int y, int count) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		
		if (dp[x][y] > 0) {
			return;
		}
		dp[x][y] = count;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= map.length) {
				continue;
			}
			if (ny < 0 || ny >= map[0].length) {
				continue;
			}
			
			if (map[nx][ny] == 1) {
				visited(dp, map, nx, ny, count);
			}
		}
	}
}