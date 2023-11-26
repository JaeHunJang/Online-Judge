import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int k = sc.nextInt();
            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0; i < k; i++) {
                int n = sc.nextInt();
                if(n > 0) stack.push(n);
                else stack.pop();
            }
			System.out.println("#" + test_case + " " + stack.stream().mapToInt(Integer::intValue).sum());
		}
	}
}