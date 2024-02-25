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
		br.readLine();
		String input = br.readLine();
		sb.append(Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).min().getAsInt()).append(" ");
		sb.append(Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).max().getAsInt());
	}
	
	static void solve() throws Exception {
		
	}
}