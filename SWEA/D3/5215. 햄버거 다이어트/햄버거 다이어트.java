import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T;
	private static int N, L, result;
	private static int count;
	private static int[][] tasteKcal;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 개수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			tasteKcal = new int[N][2]; // 재료 맛, 칼로리 배열
			visited = new boolean[N]; // 방문 배열
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				tasteKcal[i][0] = Integer.parseInt(st.nextToken());
				tasteKcal[i][1] = Integer.parseInt(st.nextToken());
			}
			
			result = 0; // 제일 큰 맛 점수
			solve();
			sb.append("\n");
		}
	}
	
	private static void solve() throws Exception {
		subset(0, 0);
		sb.append(result);
	}
	
	private static void subset(int cnt, int kcal) {
		count++;
		if (kcal > L) return;
		if (cnt == N) {
			if (L >= kcal) {
				int taste = 0;
				for (int i = 0; i < N; i++) {
					if (visited[i]) taste += tasteKcal[i][0];
				}
				result = Math.max(result, taste);
			}
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1, kcal + tasteKcal[cnt][1]);
		visited[cnt] = false;
		subset(cnt+1,  kcal);
	}	
}