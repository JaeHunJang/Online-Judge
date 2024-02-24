import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int A, B, C;
	
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	static void print() {
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
	}
	
	static void solve() throws Exception {
		char[] numbers = ((A*B*C)+"").toCharArray();
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (char num : numbers) {
				if (num-'0' == i) count++;
			}
			sb.append(count).append("\n");
		}
	}
}