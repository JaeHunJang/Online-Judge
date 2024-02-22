import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, counts[], minCount, selectedArea[];
	private static List<Integer> list[];
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
		N = Integer.parseInt(st.nextToken()); // 구역의 개수
		minCount = Integer.MAX_VALUE;
		
		counts = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			counts[i] = Integer.parseInt(st.nextToken()); // 구역별 인구수
		}
		list = new List[N+1];
		int to, n;
		for (int from = 1; from <= N; from++) {
			list[from] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 인접 구역의 개수
			for (int j = 0; j < n; j++) {
				to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
		}
	}
	
	private static void solve() throws Exception {		
		for (int i = 1; i <= N/2+1; i++) {
			selectedArea = new int[i];
			selectArea(0, 1, i, 0);
			
		}
		
		if (minCount == Integer.MAX_VALUE) minCount = -1;
		
		sb.append(minCount);
	}
	
	private static void selectArea(int cnt, int start, int k, int sum) {
		if (cnt == k) {
			minCount = Math.min(minCount, bfs(new boolean[N+1]));
			return;
		}
		
		for (int i = start; i <= N; i++) {
			selectedArea[cnt] = i;
			selectArea(cnt+1, i+1, k, sum+counts[i]);
		}
	}
	
	private static int bfs(boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(selectedArea[0]);
		visited[selectedArea[0]] = true;
		
		int sum = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			sum += counts[cur]; // 구역내 인구 합

			for (int node : list[cur])  {
				for (int i = 0; i < selectedArea.length; i++) {
					if (!visited[node] && selectedArea[i] == node) {
						visited[node] = true;
						queue.offer(node);
						break;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			queue.offer(i);
			visited[i] = true;
			break;
		}
		
		
		int sum2 = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sum2 += counts[cur]; // 구역내 인구 합

			for (int node : list[cur])  {
				if (visited[node]) continue;
				visited[node] = true;
				queue.offer(node);
			}
		}
		
		boolean flag = true;
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) flag = false;
		}
		if (flag) return Math.abs(sum - sum2);
		
		return Integer.MAX_VALUE;
	}
}