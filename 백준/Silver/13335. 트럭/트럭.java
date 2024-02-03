import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int W;
	private static int L;
	private static int time;
	private static Queue<Integer> trucks;
	private static Queue<Integer> bridge;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		trucks = new ArrayDeque<>();
		bridge = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 트럭수
		W = Integer.parseInt(st.nextToken()); // 다리 길이
		L = Integer.parseInt(st.nextToken()); // 다리 최대 하중
		time = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			bridge.offer(0);
		}
		for (int i = 0; i < N; i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}
	}
	
	private static void solve() {
		while (!trucks.isEmpty()) { // 트럭이 다 지나갈때까지 반복
			time++; // 한번 반복할때마다 시간 증가
			
			if (!bridge.isEmpty()) {
				bridge.poll();
			}
			
			if (bridge.stream().mapToInt(Integer::intValue).sum() + trucks.peek() <= L
					&& bridge.size() < W) { // 다리위에 트럭이 올라갈 수 있으면 트럭 추가
				bridge.offer(trucks.poll());
			} else {
				bridge.offer(0);
			}
		}
		sb.append(time + bridge.size());
	}
}