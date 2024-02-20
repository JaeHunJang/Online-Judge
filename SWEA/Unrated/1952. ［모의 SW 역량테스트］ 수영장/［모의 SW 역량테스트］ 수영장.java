import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T, fees[], useMonthPlan[], fee;
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			fees = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < fees.length; i++) {
				fees[i] = Integer.parseInt(st.nextToken());
			}
			
			useMonthPlan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < useMonthPlan.length; i++) {
				useMonthPlan[i] = Integer.parseInt(st.nextToken());
			}
			
			fee = fees[3]; // 1년 요금으로 초기화
			solve();
			sb.append("#").append(tc).append(" ").append(fee).append("\n");
		}
	}
	
	private static void solve() throws Exception {
		dfs(0, 0);
	}
	
	private static void dfs(int month, int totalFee) {
		if (totalFee > fee) return;
		if (month >= 12) {
			fee = Math.min(fee, totalFee);
			return;
		}
		
		if (useMonthPlan[month] > 0) {
			dfs(month + 3, totalFee + fees[2]); // 3개월
			dfs(month + 1, totalFee + fees[1]); // 1개월
			dfs(month + 1, totalFee + (fees[0] * useMonthPlan[month]));
		} else {
			dfs(month + 1, totalFee);
		}
	}
}
