import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			String[] exp = sc.next().split("");;
			Stack<String> stack = new Stack<>();
			
			for(int i = 0; i < exp.length; i++) {
				if(exp[i].equals("+")) continue;
				else if(exp[i].equals("*")) {
					stack.push((Integer.parseInt(stack.pop()) * Integer.parseInt(exp[++i]))+"");
				} else {
					stack.push(exp[i]);
				}
			}
            
			System.out.println("#" + test_case + " " + stack.stream().mapToInt(Integer::parseInt).sum());
		}
	}
}