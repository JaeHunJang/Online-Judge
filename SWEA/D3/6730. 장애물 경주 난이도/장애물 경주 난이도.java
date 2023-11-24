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
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
			    arr[i] = sc.nextInt();
			}
			
			int max = 0;
			int min = 0;
			for(int i = 1; i < n; i++) {
				max = Math.max(arr[i] - arr[i-1], max);
				min = Math.min(arr[i] - arr[i-1], min);
			}
			
			System.out.println("#" + test_case + " " + max + " " + Math.abs(min));
		}
	}
}