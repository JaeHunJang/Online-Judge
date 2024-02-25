import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	static void print() {
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int sum = 0;
			int cnt = 1;
			for (String s : br.readLine().split("")) {
				if (s.equals("O")) {
					sum += cnt;
					cnt++;
				} else {
					cnt = 1;
				}
			}
			sb.append(sum).append("\n");
		}
	}
	
	static void solve() throws Exception {
		
	}
}