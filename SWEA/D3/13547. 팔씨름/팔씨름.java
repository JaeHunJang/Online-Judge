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
			String answer = "NO";
			String s = sc.next();
			
			if (8 > Arrays.stream(s.split("")).filter(ch -> ch.equals("x")).count()) 
				answer = "YES";
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}