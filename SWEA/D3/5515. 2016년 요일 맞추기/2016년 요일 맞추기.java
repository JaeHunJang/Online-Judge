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
            int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int m = sc.nextInt();
            int d = sc.nextInt();
            
            for (int i = 0; i + 1 < m; i++) 
                d += days[i];
            
			System.out.println("#" + test_case + " " + ((d + 3) % 7));
		}
	}
}