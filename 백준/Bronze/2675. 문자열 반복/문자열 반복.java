import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, repeat;
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	static void print() {
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			repeat = Integer.parseInt(st.nextToken());
			for (String s : st.nextToken().split("")) {
				for (int j = 0; j < repeat; j++) {
					sb.append(s);
				}
			}
			sb.append("\n");
		}
	}
	
	static void solve() throws Exception {
		
	}
}