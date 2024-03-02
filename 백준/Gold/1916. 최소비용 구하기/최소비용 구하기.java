import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M, start, end;
	static List<int[]> list[];
	
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
		N = Integer.parseInt(br.readLine()); // 모눈종이
		M = Integer.parseInt(br.readLine()); // 모눈종이
		
		list = new List[N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (list[from] == null) list[from] = new ArrayList<>();
				
				list[from].add(new int[] {from, to, Integer.parseInt(st.nextToken())});
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
	}
	
	private static void solve() throws Exception {
		dijkstra();
	}
	
	private static void dijkstra() {
		boolean visited[] = new boolean[N+1];
		int weights[] = new int[N+1];
		Arrays.fill(weights, Integer.MAX_VALUE);
		
		weights[start] = 0;
		
		int min = 0, stopOver = 0;
		for (int i = 1; i <= N; i++) { // 모든 정점이 다 처리될때까지 반복
			// step1 : 미방문 정점 중 출발지에서 가장 가까운 정점 선택
			min = Integer.MAX_VALUE;
			stopOver = -1;
			
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > weights[j]) { // 아직 처리되지 않은 정점이면서 최소값이 더 작은 것
					min = weights[j];
					stopOver = j;
				}
			}
			
			if (stopOver == -1) break; // 만약 못찾았으면 종료
			visited[stopOver] = true; // 찾았으면 방문 처리
			if (stopOver == end) break; // 도착점이면 끝내기!!
			
			// step2 : 미방문 정점들에 대해 선택된 경유지를 거쳐서 가는 비용과 기존 최소비용을 비교해서 업데이트
            if(list[stopOver] == null) continue;
			for (int temp[] : list[stopOver]){
				if (// !visited[temp.vertex] && // 조건 생략 가능 
						weights[temp[1]] > min + temp[2]) {
					weights[temp[1]] = min + temp[2];
				}
				
			}
		}
		sb.append(weights[end]);
	}
}