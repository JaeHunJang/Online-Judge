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
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            int max = Math.min(a, b);
            int min = (a + b) - n;
            min = min < 0 ? 0 : min;
            
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
}