import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<String> stack = new Stack<>();
		String now = "";
		for(int i = 0; i < n; i++) {
			now = br.readLine();
			if (now.equals("0"))
				stack.pop();
			else stack.push(now);
		}
		
		System.out.println(stack.stream().mapToInt(Integer::parseInt).sum());
	}
}