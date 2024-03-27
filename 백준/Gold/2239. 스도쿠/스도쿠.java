import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// BOJ_2239 스도쿠
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int map[][];
	static List<Pos> list;
	static final int N = 9;
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		list = new ArrayList<>();
		
		String input;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
				if (map[i][j] == 0) list.add(new Pos(i, j));
			}
		}
		
		dfs(0);
	}
	
	static void dfs(int cnt) {
		if (cnt == list.size()) {
            printArr(map);
            System.out.println(sb.toString());
            System.exit(0);
        }
		
		int r = list.get(cnt).r;
		int c = list.get(cnt).c;
		
		boolean check[] = new boolean[N+1];
		
		for (int i = 0; i < N; i++) {
			if(map[r][i] != 0) check[map[r][i]] = true;
		}
		for (int i = 0; i < N; i++) {
			if(map[i][c] != 0) check[map[i][c]] = true;
		}
		
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		
		for (int i = sr; i < sr+3; i++) {
			for (int j = sc; j < sc+3; j++) {
				if (map[i][j] != 0) check[map[i][j]] = true;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				map[r][c] = i;
				dfs(cnt+1);
				map[r][c] = 0;
			}
		}
	}
	
	static void printArr(int map[][]) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}
}