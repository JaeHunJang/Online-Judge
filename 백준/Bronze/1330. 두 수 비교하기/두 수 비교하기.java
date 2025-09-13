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
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a == b) sb.append("==");
        else if (a > b) sb.append(">");
        else sb.append("<");
	}
	
	static void solve() throws Exception {
		
	}
}