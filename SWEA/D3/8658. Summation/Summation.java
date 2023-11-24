import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max = 0;
			int min = 1000001;
			
			for(int i = 0; i < 10; i++) {
				String s = sc.nextInt() + "";
				int sum = 0;
				for(String n : s.split(""))
					sum += Integer.parseInt(n);
				
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
}