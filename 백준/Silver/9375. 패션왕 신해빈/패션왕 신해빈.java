import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int T;
	private static int N;
	private static HashMap<String, Integer> map;
	private static int result;
	public static void main(String[] args) throws Exception {
		init();
		
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			map = new HashMap<>();
			N = Integer.parseInt(br.readLine());
			result = 1;
			
			if (N == 0) {
				sb.append(0).append("\n");
				continue;
			}
			for (int i = 0; i < N; i++) {
				String key = br.readLine().split(" ")[1];
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
			solve();
		}
	}

	private static void solve() {
		for (int count : map.values()) {
			result *= (count + 1);
		}
		sb.append(result-1).append("\n");
	}
}