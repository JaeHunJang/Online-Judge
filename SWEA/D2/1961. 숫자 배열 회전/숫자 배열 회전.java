import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		List<String> list = new ArrayList<>();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case);
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] arr90 = rotate(n, arr);
			int[][] arr180 = rotate(n, arr90);
			int[][] arr270 = rotate(n, arr180);
			
			for(int i = 0; i < n; i++) {
				String s1 = "";
				String s2 = "";
				String s3 = "";
				for(int j = 0; j < n; j++) {
					s1 += arr90[i][j];
					s2 += arr180[i][j];
					s3 += arr270[i][j];
				}
				System.out.println(s1 + " " + s2 + " " + s3);
			}
		}
	}
    public static int[][] rotate(int n, int[][] arr) {
		int[][] arr90 = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr90[j][n-1-i] = arr[i][j];
			}
		}
		return arr90;
	}
}