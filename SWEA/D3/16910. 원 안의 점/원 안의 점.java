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
			int n = sc.nextInt();
			
			int answer = 0;
			for(int i = 0; i < n+n+1; i++) {
				for(int j = 0; j < n+n+1; j++) {
					if (Math.pow(i-n, 2) + Math.pow(j-n, 2) <= n*n) answer++;
				}
			}
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}