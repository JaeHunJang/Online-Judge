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
            int n = sc.nextInt();
            int d = sc.nextInt();
			System.out.println("#" + test_case + " " + (int)Math.ceil(n / (d * 2 + 1.0)));
		}
	}
}