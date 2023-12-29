import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
//		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = 10;
			int max = 0;
			for(int i = 0; i < n; i++) {
				max = Math.max(max, sc.nextInt());
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}