import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static TreeMap<Integer, Integer> map;
	private static int T;
	private static int N;
	public static void main(String[] args) throws Exception {
		init();
		
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			map = new TreeMap<>();
			N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				solve();
			}
			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
	}

	private static void solve() {
		String command = st.nextToken();
		int num = Integer.parseInt(st.nextToken());
		if ("I".equals(command)) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		else if (!map.isEmpty()) {
			if (num > 0) {
				num = map.lastKey(); 
			}
			else {
				num = map.firstKey();
			}
			if (map.get(num) <= 1)
				map.remove(num);
			else {
				map.put(num, map.get(num) - 1);
			}
		}
	}
}