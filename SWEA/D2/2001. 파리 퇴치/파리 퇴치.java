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
            System.out.print("#" + test_case + " ");
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) 
                for(int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n-m+1; i++) {
                for(int j = 0; j < n-m+1; j++) {
                    list.add(sum(m,i,j,arr));
                }
            }
            System.out.println(list.stream().mapToInt(Integer::intValue).max().getAsInt());
		}
	}
    public static int sum(int m, int i, int j, int[][] arr) {
		int sum = 0;
		for(int x = i; x < i + m; x++) {
			for(int y = j; y < j + m; y++) {
				sum += arr[x][y];
			}
		}
		return sum;
	}
}