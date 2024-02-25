import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Map<Integer, Integer> map;
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	static void print() {
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		map = new HashMap<>();
		int mod;
		for (int i = 0; i < 10; i++) {
			mod = Integer.parseInt(br.readLine()) % 42;
			map.put(mod, map.getOrDefault(mod, 0)+1);
		}
		System.out.println(map.size());
	}
	
	static void solve() throws Exception {
		
	}
}