import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[][] board = new String[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().split("");
		}
		
		int min = 64;
		for (int i = 0; i <= n-8; i++) {
			for (int j = 0; j <= m-8; j++) {
				min = Math.min(check(board, i, j), min);
			}
		}
		
		System.out.println(min);
	}
	static int check(String[][] board, int n, int m) {
		String color = "WB";
		int start = color.indexOf(board[n][m]);
		int count = 0;
		int count2 = 0;
		for (int i = n; i < n+8; i++) {
			for (int j = m; j < m+8; j++) {
				if (!board[i][j].equals(color.charAt(start % 2) + "")) {
					count++;
				}
				start++;
				if (!board[i][j].equals(color.charAt(start % 2) + "")) {
					count2++;
				}
			}
			start++;
		}
		return Math.min(count, count2);
	}
}