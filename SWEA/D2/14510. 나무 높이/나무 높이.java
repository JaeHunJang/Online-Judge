import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*https://ghs4593.tistory.com/12*/
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, trees[];
	
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
			N = Integer.parseInt(st.nextToken()); // 나무 개수
			trees = new int[N];
			
			st = new StringTokenizer(br.readLine()); 
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(trees);

			solve();
		}
	}
	
	private static void solve() throws Exception {
		int even = 0, odd = 0;
		for (int i = 0; i < N; i++) {
			int gap = trees[N-1] - trees[i];
			if (gap == 0) continue; // 차이가 없으면 물 줄 필요가 없음
			
			even += gap / 2; // 2의 개수 계산
			odd += gap % 2;
		}
		
		if (even > odd) {  // 2가 더 많으면 홀수 날에 연속으로(1씩) 준게  이득임
			while(Math.abs(even - odd) > 1) {
				even--;
				odd += 2;
			}
		}
		
		int time = 0;
		if (odd > even) time = odd * 2 -1;
		else if (even > odd) time = even * 2;
		else time = even + odd;
		
		sb.append(time).append("\n");
	}
}
