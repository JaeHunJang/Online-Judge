import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int[] heights;
	private static Stack<Tower> stack;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		N = Integer.parseInt(br.readLine()); // 탑의 개수
		
		heights = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 탑의 높이 저장
			heights[i] = Integer.parseInt(st.nextToken());
		}
		stack = new Stack<>();
	}
	
	private static void solve() {
		for (int i = 0; i < N; i++) { // 현재 탑보다 낮은 탑은 저장, 높은 탑은 제거하면서 출력
			while (!stack.isEmpty()) { 
				if (heights[i] > stack.peek().height) { // 현재탑이 저장된 탑보다 크면, 현재탑보다 큰탑이 나올때까지 탑 제거
					stack.pop();
				} else { // 현재 탑이 저장된 탑보다 작으면 저장된 탑의 순서를 출력하고, 현재탑을 저장
					sb.append(stack.peek().idx+1).append(" ");
					stack.push(new Tower(i, heights[i]));
					break;
				}
			}
		
			if (stack.isEmpty()) { // 저장된 탑이 없으면 수신받을 탑이 없기 때문에 0 출력하고 현재 탑을 저장
				sb.append("0 ");
				stack.push(new Tower(i, heights[i]));
			} 
		}
	}
}
class Tower {
	int idx;
	int height;
	public Tower(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Tower [idx=" + idx + ", height=" + height + "]";
	}
}