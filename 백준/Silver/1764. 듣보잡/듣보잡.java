import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(br.readLine(), 1);
		
		for (int i = 0; i < m; i++) {
			String key = br.readLine();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int count = 0;
		ArrayList<String> duplicate = new ArrayList();
		for (String key : map.keySet()) {
			if (map.get(key) > 1) {
				duplicate.add(key);
				count++;
			}
		}
		Collections.sort(duplicate);
		
		StringBuilder sb = new StringBuilder();
		sb.append(count);
		for (int i = 0; i < count; i++) {
			sb.append("\n" + duplicate.get(i));
		}
		System.out.println(sb.toString());
	}
}