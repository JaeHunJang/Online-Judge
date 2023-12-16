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
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			boolean[] visited = new boolean[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int answer = 0;
			for (int i = 1; i <= n; i++) {
				answer += combination(arr, visited, 0, n, i, k);
	        }
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	static int combination(int[] arr, boolean[] visited, int start, int n, int r, int k) {
	    if(r == 0 && sum(arr, visited, n) == k) {
	        return 1;
	    } 

	    int result = 0;
	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        result += combination(arr, visited, i + 1, n, r - 1, k);
	        visited[i] = false;
	    }
	    
	    return result;
	}
	static int sum(int[] arr, boolean[] visited, int n) {
		int total = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	total += arr[i];
            }
        }
        return total;
    }
}