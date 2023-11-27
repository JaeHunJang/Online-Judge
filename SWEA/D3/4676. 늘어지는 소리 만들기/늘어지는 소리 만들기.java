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
			StringBuilder sb = new StringBuilder(sc.next());
			
			int n = sc.nextInt();
			
			int[] pos = new int[n];
			
			for(int i = 0; i < n; i++) {
				pos[i] = sc.nextInt();
			}
			Arrays.sort(pos);
			
			for(int i = 0; i < n; i++) {
				sb.insert(pos[i] + i, "-");
			}

			System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}