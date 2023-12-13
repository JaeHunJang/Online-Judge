import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
//		int T = sc.nextInt();
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			String[] exp = sc.next().split("");;
			Stack<Integer> stack = new Stack<>();
			Stack<String> opstack = new Stack<>();
			
			List<String> ops = Arrays.asList(new String[] {"+", "*", "(", ")"});
			
			for(int i = 0; i < exp.length; i++) {
				if(ops.contains(exp[i])) opstack.push(exp[i]);
				else stack.push(Integer.parseInt(exp[i]));
				
				if (opstack.peek().equals(")")) {
					opstack.pop(); //닫는 괄호 제거
					
					Stack<Integer> plusStack = new Stack<>();
					while(!opstack.isEmpty() && !opstack.peek().equals("(")) {
						if(opstack.peek().equals("+")) {
							plusStack.push(stack.pop());
						} else if(opstack.peek().equals("*")) {
							stack.push(stack.pop() * stack.pop());
						}
						opstack.pop(); //연산자 제거
					}
					stack.push(stack.pop() + plusStack.stream().mapToInt(Integer::intValue).sum());
					opstack.pop(); //여는 괄호 제거
				}
				
			}
			
			System.out.println("#" + test_case + " " + stack.stream().mapToInt(Integer::intValue).sum());
		}
	}
}