import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = 10;
			int result = 0;
			for(int i = 0; i < n; i++) {
				int k = sc.nextInt();
				if(k % 2 == 1) {
					result += k;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}