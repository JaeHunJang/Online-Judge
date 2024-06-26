import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 불안한 무빙워크 / 120분 
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static ArrayDeque<Integer> movingWalk;
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		movingWalk = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N*2; i++) {
			movingWalk.offer(Integer.parseInt(st.nextToken()));
		}
		
		solve();
	}

	
	static void solve() {
		int cnt = 0;
		int pos[] = new int[N];
		Stack<Integer> stack = new Stack<>();

		int count = 0;
		while (true) {
			count++;
			movingWalk.addFirst(movingWalk.pollLast()); // 1칸 회전
			for (int i = N-2; i >= 0; i--) {
				pos[i+1] = pos[i];
				pos[i] = 0;
			}
			
			for (int i = 0; i < N; i++) { // 사람이 위치할 무빙워크 꺼내두기
				stack.push(movingWalk.poll());
			}
			
			pos[N-1] = 0;
			for (int i = N-2; i >= 0; i--) {
				if (pos[i+1] == 0 && stack.peek() > 0) {
					pos[i+1] = pos[i];
					pos[i] = 0;
					if (pos[i+1] == 1) movingWalk.offerFirst(stack.pop() - 1);
					else movingWalk.offerFirst(stack.pop());
					if (movingWalk.peek() == 0) cnt++;
				} else {
					movingWalk.offerFirst(stack.pop());
				}
			}
			
			if (pos[0] == 0 && stack.peek() > 0) {
				pos[0] = 1;
				movingWalk.offerFirst(stack.pop()-1);
				if (movingWalk.peek() == 0) cnt++;
			} else {
				movingWalk.offerFirst(stack.pop());
			}
			
			if (cnt >= K) break;
		}
		
		sb.append(count);
	}
}