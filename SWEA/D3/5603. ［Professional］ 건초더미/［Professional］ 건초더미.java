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
			int[] arr = new int[n];
			
			int avg = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				avg += arr[i];
			}
			avg /= n;
			
			for(int i = 0; i < n; i++) {
				arr[i] -= avg;
			}
			
			System.out.println("#" + test_case + " " + Arrays.stream(arr).filter(num -> num < 0).sum() * -1);
		}
	}
}