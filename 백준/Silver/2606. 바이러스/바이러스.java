import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, E;
	static List<Integer> list[];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		list = new List[N+1];
		visited = new boolean[N+1];
		
		int from, to;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if (list[from] == null) {
				list[from] = new ArrayList<>();
			}
			list[from].add(to);
			
			if (list[to] == null) {
				list[to] = new ArrayList<>();
			}
			list[to].add(from);
		}
		
		solve();
	}
	
	
	private static void solve() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		visited[1] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if (list[cur] == null) continue;
			for (int to : list[cur]) {
				if (visited[to]) continue;
				q.offer(to);
				visited[to] = true;
				cnt++;
			}
		}
		sb.append(cnt);
	}


}
