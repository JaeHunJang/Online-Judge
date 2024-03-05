import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static List<Edge> list;
	static final int INF = 987654321;
	
	static class Edge {
		int from, to, time;

		public Edge(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		int from, to, time;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			list.add(new Edge(from, to, time));
		}
		
		solve(N);
	}
	
	private static void solve(int N) throws Exception {
		bfs(1, N);
	}

	private static void bfs(int start, int V) {
		long weights[] = new long[V+1];
		Arrays.fill(weights, INF);
		weights[start] = 0;
		
		
		for (int v = 1; v < V; v++) { // 정점(V-1) 개만큼
			for (int i = 0; i < list.size(); i++) { // 모든 간선을 확인
				Edge edge = list.get(i);
				
				if (weights[edge.from] != INF && weights[edge.to] > weights[edge.from] + edge.time) {
					weights[edge.to] = weights[edge.from] + edge.time;
				}
			}
		}
			
		for (int i = 0; i < list.size(); i++) { // 음수 사이클이 존재하는지 확인
			Edge edge = list.get(i);
			
			if (weights[edge.from] != INF && weights[edge.to] > weights[edge.from] + edge.time) {
				sb.setLength(0);
				sb.append(-1);
				return;
			}
		}
			
		for (int i = 2; i < weights.length; i++) {
			if (weights[i] == INF) weights[i] = -1;
			sb.append(weights[i]).append("\n");
		}
	}
}
