import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, count, idx;
	private static String input, result;
	private static char resultArr[];
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		N = Integer.parseInt(br.readLine()); // 스위치 개수
		input = br.readLine();
		result = br.readLine();
		resultArr = result.toCharArray();
		
		count = Integer.MAX_VALUE;
		idx = 0;
	}
	
	private static void solve() throws Exception {
		if (input.equals(result)) {
			sb.append(0);
			return;
		}
		start();
		if (count == Integer.MAX_VALUE) count = -1;
		sb.append(count);
	}
	private static void start() {
		idx = 1;
		middle(input.toCharArray(), 0); // 처음 스위치 안누른 경우
		idx = 1;
		middle(onOff(onOff(input.toCharArray(), 0), 1), 1); // 처음 스위치 누른 경우
	}
	
	private static void middle(char[] input, int cnt) {
		while (idx < N-1) {
			if (input[idx-1] != resultArr[idx-1]) {
				input = onOff(input, idx-1);
				input = onOff(input, idx);
				input = onOff(input, idx+1);
				cnt++;
			}
			idx++;
		}
		end(input, cnt);
	}
	
	private static void end(char[] input, int cnt) {
		if (input[idx-1] != resultArr[idx-1] && input[idx] != resultArr[idx]){
			input = onOff(input, idx-1);
			input = onOff(input, idx);
			cnt++;
		}
		
		if (new String(input).equals(result)) {
			count = Math.min(count, cnt);
		}
	}
	
	private static char[] onOff(char[] input, int idx) {// 스위치 온오프 함수
		if (input[idx] == '0') {
			input[idx] = '1';
		} else {
			input[idx] = '0';
		}
		return input;
	}
	
}