import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = (int) Math.pow(2, sc.nextInt());
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println("#" + test_case + " " + tournament(arr, n, 0));
		}
	}
	public static int tournament(int[] entry, int n, int answer) {
		if(n <= 1) return answer;
		int round = n / 2;
		int[] result = new int[round];
		int idx = 0;
		for(int i = 0; i < n; i+=2) {
			answer += Math.abs(entry[i] - entry[i+1]);
			result[idx++] = Math.max(entry[i], entry[i+1]);
		}
		
		return tournament(result, round, answer);
	}
}