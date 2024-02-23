import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, count, cols[], rightDown[], leftDown[];
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 체스판 길이
		cols = new int[N+1]; // 열에 둔 위치
		leftDown = new int[N*2+1]; // 왼쪽 대각선
		rightDown = new int[N*2+1]; // 오른쪽 대각선
		count = 0;
	}
	
	private static void solve() throws Exception {
		dfs(1);
		sb.append(count);
	}
	
	private static void dfs(int row) {
		if (row == N+1) {
			count++;
			return;
		}

		/*
		 * 		col
		 * 	row	1,1 1,2 1,3 1,4		cols { 0, 1, 0, 0 }
		 * 		2,1 2,2 2,3 2,4		leftDown { 0, 0, 1, 0, 0, 0, 0, 0 }
		 * 		3,1 3,2 3,3 3,4		rightDown { 0, 0, 0, 1, 0, 0, 0, 0 }
		 * 		4,1 4,2 4,3 4,4
		 * 
		 *  cols[col] 열에 이미 존재하는지  확인
		 *	leftDown[row+col]  1,2 에 퀸이 있을 때, row + col (1+2=3) 로 왼쪽 대각선에 퀸에 영향을 받는지 확인 가능하다.
		 *	ex) 2,2 에 퀸이 있는 경우 [1,3][3,1] 은 퀸에 영향을 받는데 이를 2+2=4 해서 leftDown[4] = 1 로 값을 넣어두면 대각선 관계에 영향을 주는지 확인 가능하다.
		 *	
		 *	rightDown[N+(row-col)+1] 1,2 에 퀸이 있을 때, N+(row-col)+1 (4+(1-2)+1=4) 로 오른쪽 대각선에 퀸에 영향을 받는지 확인
		 *	ex) 2,2 에 퀸이 있는 경우 [1,1][3,3][4,4] 은 영향을 받는데 이를 각각 (4+(1-1)+1=5),(4+(3-3)+1=5)(4+(4-4)+1=5) 해서 rightDown[5] = 1 로 확인 가능하다. 
		 *  
		 */
		for (int col = 1; col <= N; col++) {
			if (cols[col] == 1 || leftDown[row+col] == 1 || rightDown[N+(row-col)+1] == 1) continue;
			
			cols[col] = 1;
			leftDown[row+col] = 1;
			rightDown[N+(row-col)+1] = 1;
			dfs(row+1);
			cols[col] = 0;
			leftDown[row+col] = 0;
			rightDown[N+(row-col)+1] = 0;
		}
	}
}