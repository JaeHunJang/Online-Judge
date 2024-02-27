import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int V, E, K, weights[];
	static final int INF = Integer.MAX_VALUE;
	static List<Node> list[];
	static boolean visited[];
	static class Node {
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
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
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(br.readLine()); // 시작 정점

		weights = new int[V+1];
		visited = new boolean[V+1];
		Arrays.fill(weights, INF);
		
		list = new List[V+1];
		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			if (list[from] == null) list[from] = new ArrayList<>();
			list[from].add(new Node(to, weight));
		}
	}
	
	private static void solve() throws Exception {
		weights[K] = 0; // 시작 정점 초기화
		
		int min, minIdx;
		for (int i = 1; i <= V; i++) {
			min = INF;
			minIdx = -1;
			
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > weights[j]) {
					min = weights[j];
					minIdx = j;
				}
			}
			
			if (minIdx == -1) break;
			visited[minIdx] = true;
			
			if (list[minIdx] == null) continue;
			for (Node temp : list[minIdx]) {
				if (weights[temp.to] > temp.weight + min) {
					weights[temp.to] = temp.weight + min;
				}
			} 
		}
		
		for (int i = 1; i <= V; i++) {
			if (weights[i] == INF) sb.append("INF");
			else sb.append(weights[i]);
			sb.append("\n");
		}
	}
}