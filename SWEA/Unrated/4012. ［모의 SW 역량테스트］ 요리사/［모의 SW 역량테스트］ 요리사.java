import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T;
	private static int N, result;
	private static int[][] synergy;
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
			N = Integer.parseInt(st.nextToken()); // 식재료 개수
			synergy = new int[N][N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE; // 제일 작은 시너치 차이
			solve();
			sb.append("\n");
		}
	}
	
	private static void solve() throws Exception {
		visited[0] = true;
		subset(1, 1, 0); // 처음 재료는 선택한 것으로 경우의 수 줄임
		sb.append(result);
	}
	
	private static void subset(int cnt, int tCnt, int fCnt) {
		if (tCnt >= N/2+1 || fCnt >= N/2+1) return; // 균등하게 선택된 경우만 골라냄
		if (cnt == N) {
			int a=0, b=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					if (visited[i] && visited[j]) a += synergy[i][j]; // 선택한것과 안선택한 것으로 요리 a, b 계산
					else if (!visited[i] && !visited[j]) b += synergy[i][j];
				}
			}
			result = Math.min(result, Math.abs(a-b));
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1, tCnt+1, fCnt);
		visited[cnt] = false;
		subset(cnt+1, tCnt, fCnt+1);
	}	
}