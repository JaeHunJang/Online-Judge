import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, V, E, parents[];
	static Edge list[];
	static class Edge implements Comparable<Edge> {
		int from,to,w;

		public Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());  
			E = Integer.parseInt(st.nextToken());
			parents = new int[V+1];
			for (int i = 1; i <= V; i++) {
				parents[i] = i; // 자기 자신을 부모로
			}
			
			list = new Edge[E];
			int from, to, weight;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				
				list[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(list);
		
			solve();
		}
	}
	
	private static void solve() throws Exception {
		long sum = 0, cnt = 0;
		for (int i = 0; i < E; i++) {
			if (union(list[i].from, list[i].to)) {
				sum += list[i].w;
				cnt++;
			}
			if (cnt == V-1) break;
		}
		sb.append(sum).append("\n");
	}
	
	static int find(int x) {
		if (parents[x] == x) return parents[x];
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) return false;
		parents[pa] = pb;
		return true;
	}
}
