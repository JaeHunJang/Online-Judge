import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T;
	private static int N;
	private static int[][] map;
	private static int result; 
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
			map = new int[N][N]; 
			result = 0;
			
			for (int i = 0; i < N; i++) {
				int j = 0; 
				for (String num : br.readLine().split("")) {
					map[i][j++] = Integer.parseInt(num);
				}
			}
			solve(); 
		}
	}
	
	private static void solve() {
		for (int i = 0; i < N/2; i++) {
			int j = 0;
			for (; j < N/2-i; j++) {
			}
			for (; j <= N/2+i; j++) {
				result += map[i][j];
			}
		}
		for (int i = 0; i < N/2+1; i++) {
			int j = 0;
			for (; j < i; j++) {
			}
			for (j=0; j < N-i*2; j++) {
				result += map[i+N/2][j+i];
			}
		}
		sb.append(result).append("\n"); // 결과값 저장
		
		
	}
}