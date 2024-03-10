import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M, minNode, minCount;
	static List<Integer> list[];
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minNode = Integer.MAX_VALUE;
		minCount = Integer.MAX_VALUE;
		
		list = new List[N+1];
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if (list[from] == null) list[from] = new ArrayList<>();
			list[from].add(to);
			if (list[to] == null) list[to] = new ArrayList<>();
			list[to].add(from);
		}
		
		solve();
	}
	
	private static void solve() {
		for (int i = 1; i <= N; i++) {
			bfs(i);
//			System.out.println(minNode +"|" + minCount);
		}
		sb.append(minNode);
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		int count = 0;
		int depth = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {	
				int cur = q.poll();
				
				for (int node : list[cur]) {
					if (visited[node]) continue;
					visited[node] = true;
					count += depth;
					q.offer(node);
				}
			}
			depth++;
		}
		
		if (minCount > count) {
			minCount = count;
			minNode = start;
			
		} else if (minCount == count && minNode > start) {
			minNode = start;
		}
	}
}