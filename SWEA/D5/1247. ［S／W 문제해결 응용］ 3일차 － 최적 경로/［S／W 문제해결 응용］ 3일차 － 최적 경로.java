import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T;
	private static int N, map[][], minDistance, start[], end[];
	private static boolean visited[];
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
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][2];
			start = new int[2]; 
			end = new int[2];
			visited = new boolean[N];
			minDistance = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken()); // 회사 위치
			start[1] = Integer.parseInt(st.nextToken()); 
			end[0] = Integer.parseInt(st.nextToken()); // 집위치
			end[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) { // 고객 위치
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			solve();
			sb.append("\n");
		}
	}
	
	private static void solve() throws Exception {
		perm(0, start, 0);
		sb.append(minDistance);
	}
	
	private static void perm(int cnt, int[] before, int len) {
		if (len > minDistance) return; 
		if (cnt == N) {
			minDistance = Math.min(minDistance, len+calcDistance(before, end));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			perm(cnt+1, map[i], len+calcDistance(before, map[i]));
			visited[i] = false;
		}
	}
	
	private static int calcDistance(int[] start, int[] end) {
		return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
	}
}