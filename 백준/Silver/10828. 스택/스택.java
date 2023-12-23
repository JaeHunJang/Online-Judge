import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			String command = br.readLine();
			if(command.startsWith("push")) {
				stack.add(command.substring("push ".length()));
				continue;
			}
			switch(command) {
				case "pop" : sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n"); break;
				case "size" : sb.append(stack.size()).append("\n"); break;
				case "empty" : sb.append(stack.isEmpty() ? "1" : "0").append("\n"); break;
				case "top" : sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n"); break;
			}
		}
		
		System.out.print(sb.toString());
	}
}