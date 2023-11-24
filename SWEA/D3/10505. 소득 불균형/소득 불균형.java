import java.util.*;
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
			
			int sum = 0;
			for(int i = 0; i < n; i++) {
			    arr[i] = sc.nextInt();
			    sum += arr[i];
			}
			
			double avg = sum / n;
			
			System.out.println("#" + test_case + " " + Arrays.stream(arr).filter(num -> num <= avg).count());
		}
	}
}