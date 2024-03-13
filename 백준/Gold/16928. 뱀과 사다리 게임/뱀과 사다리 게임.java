import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀과 사다리 게임 - 120분
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static List<Pos> ladder;
	
	static class Pos {
		int from, to;

		public Pos(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
		
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 맵의 크기
		M = Integer.parseInt(st.nextToken());
		
		ladder = new ArrayList<>();
//		snake = new ArrayList<>();
//		map = new int[LEN+1][LEN+1];
		int r, c;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			ladder.add(new Pos(r, c));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			ladder.add(new Pos(r, c));
		}
		
		solve();
	}
	
	private static void solve() throws Exception {
		int cnt = bfs();
		sb.append(cnt);
	}
	
	private static int bfs() {
//		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {
//			public int compare(int[] o1, int[] o2) {
//				int ret =  Integer.compare(o1[0], o2[0]);
////				if (ret == 0) return Integer.compare(o2[1], o1[1]);
//				return ret;
//			}
//		});
		Queue<int []> pq = new ArrayDeque<>();
		boolean visited[] = new boolean[101];
		pq.offer(new int[] {0, 1});
		visited[1] = true;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
//			System.out.println(Arrays.toString(cur));
			if (cur[1] == 100) return cur[0];
            
			for (int i = 1; i <= 6; i++) {
				boolean isMove = false; // 사다리나 뱀으로 움직였는지 여부
				int to = cur[1]+i;
				if (to > 100) continue;
				for (Pos l : ladder) {
//					System.out.println(to + "|" + l.from + "|"+ l.to);
					if (visited[l.from]) continue;
					if (l.from == to) {
						pq.offer(new int[] {cur[0]+1, l.to});
						visited[l.from] = true;
						isMove = true;
						break;
					}
				}
				if (!isMove) { // 사다리나 뱀을 못탔으면 주사위만큼 움직임
					if (visited[to]) continue;
					pq.offer(new int[] {cur[0]+1, to});
					visited[to] = true;
				}
			}
		}
		
		return -1;
	}
}
