import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M, minDistance;
	static List<Node> list[];
	static boolean visited[];
	static class Node {
		int from, to, w;

		public Node(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", w=" + w + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 크기
		minDistance = Integer.MAX_VALUE; // 최소 이동거리
		
		visited = new boolean[N];
		list = new List[N]; // 그래프
		for (int from = 0; from < N; from++) {
			st = new StringTokenizer(br.readLine());
			for (int to = 0; to < N; to++) {
				int w = Integer.parseInt(st.nextToken());
				if (w == 0) continue;
				if (list[from] == null) list[from] = new ArrayList<>();
				list[from].add(new Node(from, to, w));
			}
		}
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(1, i, 0, i);
			
		}
		sb.append(minDistance);
	}
	
	private static void dfs(int cnt, int from, int dist, int start) {
		if (dist > minDistance) return;
		if (cnt == N) {
			int ret = -1;
			for (Node node : list[from]) {
				if (node.to == start) ret = node.w;
			}
			if (ret == -1) return;
			minDistance = Math.min(minDistance, dist+ret);
			return;
		}
		
		for (Node node : list[from]) {
			if (visited[node.to]) continue;
			visited[node.to] = true;
			dfs(cnt+1, node.to, dist+node.w, start);
			visited[node.to] = false;
		}
	}
}