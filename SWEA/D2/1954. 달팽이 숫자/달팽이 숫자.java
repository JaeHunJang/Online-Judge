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
            System.out.println("#" + test_case);
            int n = sc.nextInt();
            int[][] answer = new int[n][n];
            int i = 1;
            int x = 0;
            int y = 0;
            answer[y][x] = i++;
            while(i <= n*n) {
                while(x < n-1 && answer[y][x+1] == 0)  {
                    x++;
                    answer[y][x] = i++;
                }
                while(y < n-1 && answer[y+1][x] == 0) {
                    y++;
                    answer[y][x] = i++;
                }
                while(x > 0 && answer[y][x-1] == 0) {
                    x--;
                    answer[y][x] = i++;
                }
                while(y > 0 && answer[y-1][x] == 0) {
                    y--;
                    answer[y][x] = i++;
                }
            }
            for(int[] arr : answer) {
                for(int a : arr) 
                    System.out.print(a + " ");
                System.out.println();
            }
            
		}
	}
}