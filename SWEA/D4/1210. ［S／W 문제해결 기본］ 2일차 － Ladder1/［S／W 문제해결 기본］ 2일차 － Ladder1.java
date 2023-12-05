import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			int size = 100;
			int[][] data = new int[size][size];
			int[] direction = {-1, 1};
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			
			int target = -1;
			for(int i = 0; i < size; i++) {
				if(data[99][i] == 2) target = i;		
			}
			
			int height = 99;
			int d = 0;
			while(height >= 0) {
				d = 0;
				for(int i = 0; i < direction.length; i++) {
					while(target + direction[i] >= 0 && target + direction[i] < size && data[height][target + direction[i]] == 1) {
						d = direction[i];
						target += direction[i];
					}
					if(d != 0) {
						height--;
						break;
					}
				}
				if (d == 0) height--;
			}
			
			System.out.println("#" + n + " " + target);
		}
	}
}