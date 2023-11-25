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
            String num = sc.next();
            String answer = Integer.parseInt(num.charAt(num.length()-1) + "") % 2 == 0 ? "Even" : "Odd";
			System.out.println("#" + test_case + " " + answer);
		}
	}
}