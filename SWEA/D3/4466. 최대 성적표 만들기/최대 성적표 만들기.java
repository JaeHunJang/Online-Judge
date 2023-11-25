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
            int k = sc.nextInt();
            
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            
            Arrays.sort(arr);
            
            int answer = 0;
            for(int i = 0; i < k; i++)
                answer += arr[n-i-1];
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}