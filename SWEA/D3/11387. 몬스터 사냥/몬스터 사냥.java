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
            int d = sc.nextInt();
            int l = sc.nextInt();
            int n = sc.nextInt();
            long answer = 0;
            
            for(int i = 0; i < n; i++) {
                answer += d + d * i * l / 100;
            }
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}