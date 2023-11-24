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
			int k = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < k; i++) {
				arr[sc.nextInt()-1] = 1;
			}
			
			String answer = "";
			for(int i = 0; i < n; i++) {
				if(arr[i] == 0) answer += i + 1 + " ";
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}