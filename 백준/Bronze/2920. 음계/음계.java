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
		String input = br.readLine();
		if ("1 2 3 4 5 6 7 8".equals(input)) sb.append("ascending");
		else if ("8 7 6 5 4 3 2 1".equals(input)) sb.append("descending");
		else sb.append("mixed");
	}
	
	static void solve() throws Exception {
		
	}
}