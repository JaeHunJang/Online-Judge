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
			int[] arr = new int[n];
			boolean[] visited = new boolean[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int num = 0;
			int result = -1;
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					num = arr[i] * arr[j];
					if (num > result && check(num)) {
						result = num;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
	static boolean check(int n) {
		char[] temp = (n+"").toCharArray();
		for(int i = 1; i < temp.length; i++) {
			if(temp[i-1] > temp[i]) return false;
		}
		return true;
    }
} 