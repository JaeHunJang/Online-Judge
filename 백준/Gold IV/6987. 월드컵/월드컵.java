import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static class Country implements Comparable<Country> {
		int win, draw, lose;

		public Country(int win, int draw,  int lose) {
			this.win = win;
			this.lose = lose;
			this.draw = draw;
		}

		
		@Override
		public String toString() {
			return "Country [win=" + win + ", draw=" + draw + ", lose=" + lose + "]";
		}


		@Override
		public int compareTo(Country o) {
			// TODO Auto-generated method stub
			if (o.win == this.win) {
				return this.lose - o.lose;
			}
			return o.win - this.win;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + draw;
			result = prime * result + lose;
			result = prime * result + win;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Country other = (Country) obj;
			if (draw != other.draw)
				return false;
			if (lose != other.lose)
				return false;
			if (win != other.win)
				return false;
			return true;
		}
	}
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T, N, totalRound, answer, nums[][];
	private static Country result[], dp[];
	public static void main(String[] args) throws Exception {
		init();
//		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		T = 4; // 결과 개수
		N = 6; // 나라
		
		result = new Country[N];
		totalRound = N * (N-1);
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			dp = new Country[N];
			answer = 0;
			
			nums = new int[totalRound/2][2];
			for (int i = 0; i < N; i++) {
				result[i] = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				dp[i] = new Country(0, 0, 0);
			}
			
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
//					System.out.println(i + "," + j);
					nums[idx][0] = i;
					nums[idx++][1] = j;
				}
			}
//			Arrays.sort(result); // 보기 편하려고 정렬 한번
			
//			System.out.println(t+"-------------------");
//			for (int i = 0; i < N; i++) {
//				System.out.println(result[i]);
//			}
//			System.out.println(t+"===================");
			solve();
			sb.append(answer).append(" ");
		}
	}
	
	private static void solve() throws Exception {
//		if (normalCheck()) {
			dfs(0);
//		}
	}
	
	private static void dfs(int cnt) {
		if (answer == 1) return;
		if (cnt == totalRound/2) {
			boolean flag = true;
			for (int i = 0; i < dp.length; i++) {
				if (!dp[i].equals(result[i])) {
					flag = false;
				}
//				System.out.println(dp[i]);
			}
			if (flag) {
				answer = 1;
			}
//			System.out.println(answer);
			return;
		}
		
		if (dp[nums[cnt][0]].win > result[nums[cnt][0]].win 
				|| dp[nums[cnt][0]].draw > result[nums[cnt][0]].draw 
				|| dp[nums[cnt][0]].lose > result[nums[cnt][0]].lose ) return;
		
		
		dp[nums[cnt][0]].win++;
		dp[nums[cnt][1]].lose++;
		dfs(cnt+1);
		dp[nums[cnt][0]].win--;
		dp[nums[cnt][1]].lose--;
		
		dp[nums[cnt][0]].draw++;
		dp[nums[cnt][1]].draw++;
		dfs(cnt+1);
		dp[nums[cnt][0]].draw--;
		dp[nums[cnt][1]].draw--;
		
		dp[nums[cnt][0]].lose++;
		dp[nums[cnt][1]].win++;
		dfs(cnt+1);
		dp[nums[cnt][0]].lose--;
		dp[nums[cnt][1]].win--;
		
	}
	
//	private static boolean normalCheck() {
//		for (int i = 0; i < result.length; i++) {
//			if (!roundCheck(i)) {
//				answer = 0;
//				return false;
//			}
//			win += result[i].win;
//			draw += result[i].draw;
//			lose += result[i].lose;
//		}
//		if (!(totalRoundCheck() && winLoseCheck() && drawCheck())) {
//			answer = 0;
//			return false;
//		}
//		return true;
//	}
//	
//	private static boolean roundCheck(int idx) {
//		return result[idx].win + result[idx].draw + result[idx].lose == N - 1;
//	}
//	
//	private static boolean totalRoundCheck() {
//		return (win + draw + lose) == totalRound; 
//	}
//	
//	private static boolean winLoseCheck() {
//		int round = (totalRound - draw) / 2; // 승패 라운드
//		if (win == lose && round == win && round == lose) {
//			return true;
//		}
//		return false;
//	}
//	
//	private static boolean drawCheck() {
//		if (draw % 2 == 0) {
//			int count = 0;
//			for (int i = 0; i < N; i++) {
//				if (count == 0) count = result[i].draw;
//				else if (count > 0) count -= result[i].draw;
//				else if (count < 0) count += result[i].draw;
//			}
//			return count == 0;
//		}
//		return false;
//	}
}