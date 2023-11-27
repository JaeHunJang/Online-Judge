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
			
			int answer = 0;
			for(int i = 1; i <= n; i++) {
				int sum = 0;
				for(int j = i; sum < n; j++) {
					sum += j;
				}
				if (sum == n) answer++;
			}
			if (n == 1) answer = 1;
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}