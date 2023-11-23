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
			int k = sc.nextInt();
			
			int[][] map = new int[n][n];
			List<Integer> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();
			
			for(int i = 0; i < n; i++) {
				int rlength = 0;
				int hlength = 0;
				for(int j = 0; j < n; j++) {
					if(map[i][j] == 0) {
						list.add(rlength);
						rlength = 0;
					} else rlength++;
					if(map[j][i] == 0) {
						list.add(hlength);
						hlength = 0;
					} else hlength++;
				}
				if (rlength > 0) 
					list.add(rlength);
				if (hlength > 0) 
					list.add(hlength);
			}
			
			System.out.println(list.stream().filter(length -> length == k).count());
		}
	}
}