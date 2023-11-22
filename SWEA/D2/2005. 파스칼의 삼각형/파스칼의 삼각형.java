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
			System.out.println("#" + test_case);
			
			int n = sc.nextInt();
			
			int[][] triangle = new int[n][n];
			triangle[0][0] = 1;
			
			for(int height = 1; height < n; height++) {
				for(int i = 0; i < height+1; i++) {
					if (i == 0 || i == height)
						triangle[height][i] = 1;
					else
						triangle[height][i] = triangle[height-1][i-1] + triangle[height-1][i];
				}
				
			}
			
			for(int[] rows : triangle) {
				for(int cell : rows)
					if(cell > 0) System.out.print(cell + " ");
				System.out.println();
			}

		}
	}
}