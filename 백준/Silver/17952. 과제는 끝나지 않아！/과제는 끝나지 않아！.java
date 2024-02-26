import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static List<Integer> list[];
	static boolean visited[];
	static Stack<int []> stack;
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		
		int cmd, score, time, totalSum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				score = Integer.parseInt(st.nextToken());
				time = Integer.parseInt(st.nextToken())-1;
				if (time == 0) totalSum += score; // 받자마자 끝내기
				else stack.push(new int[] {score, time}); // 못끝냈으면 stack에 넣기
			} else {
				if (!stack.isEmpty()) { // 작업이 남아있으면 
					int[] cur = stack.pop();
					cur[1]--; // 하나 수행
					if (cur[1] <= 0) { // 끝났으면 점수 계산
						totalSum += cur[0];
					} else { // 안끝났으면 다시 stack에 넣기
						stack.push(cur);
					}
				}
			}
		}
		
		sb.append(totalSum);
	}
}
