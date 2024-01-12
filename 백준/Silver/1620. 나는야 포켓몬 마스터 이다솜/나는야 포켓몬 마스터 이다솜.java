import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> nums = new HashMap<>();
		HashMap<String, Integer> names = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			nums.put(i, name);
			names.put(name, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String search = br.readLine();
			if (search.matches("^\\d*$"))
				sb.append(nums.get(Integer.parseInt(search)));
			else
				sb.append(names.get(search));
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}