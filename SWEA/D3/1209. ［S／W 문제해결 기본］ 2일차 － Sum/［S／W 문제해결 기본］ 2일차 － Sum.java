import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            sc.nextInt();
			int[][] map = new int[100][100];
			
			for(int i = 0; i < map.length; i++)
				for(int j = 0; j < map[i].length; j++)
					map[i][j] = sc.nextInt();
			
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < map.length; i++) {
				int rowSum = 0;
				int colSum = 0;
				for(int j = 0; j < map[i].length; j++) {
					rowSum += map[i][j];
					colSum += map[j][i];
				}
				list.add(rowSum);
				list.add(colSum);
			}
			
			int crossSum1 = 0;
			int crossSum2 = 0;
			for(int i = 0; i < map.length; i++) {
				crossSum1 += map[i][i];
				crossSum2 += map[map.length - i - 1][i];
			}
			list.add(crossSum1);
			list.add(crossSum2);
			
			System.out.println("#" + test_case + " " + list.stream().mapToInt(Integer::intValue).max().getAsInt());
		}
	}
}