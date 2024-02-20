import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, inDegrees[];
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
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 비교 회수 
		
		list = new List[N+1];
		inDegrees = new int[N+1];
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if (list[from] == null) list[from] = new ArrayList<>();
			list[from].add(to);
			inDegrees[to]++;
		}
	}
	
	private static void solve() throws Exception {
		bfs();
	}
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		// 진입차수가 0인 노드들 q에 넣기
		for (int i = 1; i <= N; i++) {
			if (inDegrees[i] == 0) q.offer(i); 
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			inDegrees[cur]--; 
			
			sb.append(cur).append(" ");
			
			if (list[cur] == null) continue;
			for (int node : list[cur]) {
				inDegrees[node]--;
				
				if (inDegrees[node] == 0)
					q.offer(node);
			}
		}
	}
}
