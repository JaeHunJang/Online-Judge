import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
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
			
			List<Integer> goals = new ArrayList<Integer>();
			for(int i = 0; i < size; i++) {
				if(data[99][i] == 1) goals.add(i);		
			}
			
			int min = Integer.MAX_VALUE;
			int answer = -1;
			for(int target : goals) {
				int height = 99;
				int d = 0;
				int count = 0;
				while(height >= 0) {
					d = 0;
					for(int i = 0; i < direction.length; i++) {
						while(target + direction[i] >= 0 && target + direction[i] < size && data[height][target + direction[i]] == 1) {
							d = direction[i];
							target += direction[i];
							count++;
						}
						if(d != 0) {
							height--;
							count++;
							break;
						}
					}
					if (d == 0) {
						height--;
						count++;
					}
				}
				min = Math.min(min, count);
				if(min == count) answer = target;
			}
			
			System.out.println("#" + n + " " + answer);
		}
	}
}