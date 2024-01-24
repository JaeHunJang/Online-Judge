import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static Map<Integer, Person> map;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine(), "");
		N = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(i, new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
	}

	private static void solve() throws Exception {
		map.entrySet().stream()
			.sorted((o1, o2) -> {
				if (o1.getValue().age == o2.getValue().age) {
					return o1.getKey() - o2.getKey();
				}
				return o1.getValue().age - o2.getValue().age;
			}).forEach(entry -> sb.append(entry.getValue().age + " " + entry.getValue().name+"\n"));
	}
	
	static class Person {
		public int age;
		public String name;
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
	}
}