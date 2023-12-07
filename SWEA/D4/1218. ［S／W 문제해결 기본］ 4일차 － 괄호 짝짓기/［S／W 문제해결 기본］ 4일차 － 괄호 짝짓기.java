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
		
        List<String> open = Arrays.asList(new String[]{ "(", "[", "{", "<" });
        List<String> close = Arrays.asList(new String[]{ ")", "]", "}", ">" });
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			String s = sc.next();
			Stack<String> stack = new Stack<>();
			
			int answer = 1;
			for(String ch : s.split("")) {
				if(open.contains(ch)) stack.push(ch);
				else if (stack.peek().equals(open.get(close.indexOf(ch)))) stack.pop();
				else {
					answer = 0;
					break;
				}
			}
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}