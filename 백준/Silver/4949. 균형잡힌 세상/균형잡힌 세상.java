import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
		Stack<String> stack = new Stack<>();
		while (!".".equals(line)) {
			String result = "yes";
			for (String ch : line.split("")) {
				if("(".equals(ch) || "[".equals(ch)) {
					stack.push(ch);
				} else if(")".equals(ch) || "]".equals(ch)){
					if (stack.isEmpty()) {
						result = "no";
						break;
					} else if (stack.peek().equals("(") && ch.equals(")")) {
						stack.pop();
					} else if (stack.peek().equals("[") && ch.equals("]")) {
						stack.pop();
					} else {
                        result = "no";
                        break;
                    }
				}
			}
			if (stack.size() > 0) result = "no";
			System.out.println(result);
			line = br.readLine();
			stack.setSize(0);
		}
	}
}