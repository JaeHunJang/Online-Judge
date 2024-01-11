import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] visited = new int[n][m];
		visited[0][0] = 1;
		for (int i = 0; i < n; i++) {
			int j = 0;
			for (String num : br.readLine().split("")) {
				map[i][j++] = Integer.parseInt(num);
			}
		}
		
		move(map, visited, 0, 0, 1);
		System.out.println(result);
	}
	
	static void move(int[][] map, int[][] visited, int x, int y, int count) {
		int[] dx = {0, -1, 0, 1};
		int[] dy = {1, 0, -1, 0};
		if (x == map.length-1 && y == map[x].length-1) {
			result = Math.min(count, result);
			return;
		}
		
		if (count > result) return;
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= map.length) {
				continue;
			}
			if (ny < 0 || ny >= map[x].length) {
				continue;
			}
			
			if (map[nx][ny] == 1) {
				if (visited[nx][ny] == 0 || visited[nx][ny] > count) {
					visited[nx][ny] = count;
					move(map, visited, nx, ny, count+1);
				}
			}
		}
	}
}