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
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			Map<Integer, Integer> map = new HashMap<>();
			
			int max = 0;
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					map.put(i+j, map.getOrDefault(i+j, 0) + 1);
					if (map.get(i+j) > max) max = map.get(i+j);
				}
			}
			
			String answer = "";
			for(int i = 0; i < map.size(); i++) {
				if(map.getOrDefault(i, 0) == max) answer += i + " ";
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}