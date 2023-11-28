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
			int d = sc.nextInt() - 11;
			int h = sc.nextInt() - 11;
			int m = sc.nextInt() - 11;
			
			int answer = d * 24 * 60 + h * 60 + m;
			
			if (d < 0) answer = -1;
			else if (d == 0 && h < 0) answer = -1;
			else if (d == 0 && h == 0 && m < 0) answer = -1;
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}