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
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = Arrays.stream(arr).max().getAsInt();
			int count = 0;
			long sum = 0;
			long answer = 0;

			for(int i = 0; i < n; i++) {
				if(arr[i] == max) {
					answer += max * count - sum;
					sum = 0;
					count = 0;
					int startIdx = i + 1 >= arr.length ? arr.length-1 : i + 1;
					max = Arrays.stream(Arrays.copyOfRange(arr, startIdx, arr.length)).max().getAsInt();
				} else {
					count++;
					sum += arr[i];
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}