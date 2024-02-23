import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
			if (o.win == this.win) {
				return this.lose - o.lose;
			}
			return o.win - this.win;
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
		
		result = new Country[N]; // 검사할 경기 결과
		dp = new Country[N]; // 경기 결과 검사 진행 과정 저장
		
		totalRound = N * (N-1) / 2; // 전체 경기 수
		nums = new int[totalRound][2]; // 경기 매치업
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
//				System.out.println(i + "," + j);
				nums[idx][0] = i;
				nums[idx++][1] = j;
			}
		}
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			answer = 0; // 유효 여부
			
			for (int i = 0; i < N; i++) {
				result[i] = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				dp[i] = new Country(0, 0, 0);
			}
			
//			Arrays.sort(result); // 보기 편하려고 정렬 한번
//			
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
		dfs(0);
	}
	
	private static void dfs(int cnt) {
		if (answer == 1) return; // 경기 결과가 유효하면 dfs 종료
		if (cnt == totalRound) { // 경기(매치업)를 끝까지 진행
			boolean flag = true;
			for (int i = 0; i < dp.length; i++) {
				if (!dp[i].equals(result[i])) { // 경기 결과가 만들어진 검사할 경기 결과와 동일한지 비교
					flag = false;
				}
//				System.out.println(dp[i]);
			}
			if (flag) { // 경기가 동일하면 값 변경
				answer = 1;
			}
//			System.out.println(answer);
			return;
		}
		
		// 승 무 패 어느 하나라도 해당 팀 경기결과와 차이가 나면 해당 dfs 종료 -> 경기결과가 계속 틀리기 때문에 더이상 진행할 필요 없음
		if (dp[nums[cnt][0]].win > result[nums[cnt][0]].win 
				|| dp[nums[cnt][0]].draw > result[nums[cnt][0]].draw 
				|| dp[nums[cnt][0]].lose > result[nums[cnt][0]].lose ) return;
		
		// 이긴 경우
		dp[nums[cnt][0]].win++;
		dp[nums[cnt][1]].lose++;
		dfs(cnt+1);
		dp[nums[cnt][0]].win--;
		dp[nums[cnt][1]].lose--;
		
		// 무승부
		dp[nums[cnt][0]].draw++;
		dp[nums[cnt][1]].draw++;
		dfs(cnt+1);
		dp[nums[cnt][0]].draw--;
		dp[nums[cnt][1]].draw--;
		
		// 진경우
		dp[nums[cnt][0]].lose++;
		dp[nums[cnt][1]].win++;
		dfs(cnt+1);
		dp[nums[cnt][0]].lose--;
		dp[nums[cnt][1]].win--;
	}
}