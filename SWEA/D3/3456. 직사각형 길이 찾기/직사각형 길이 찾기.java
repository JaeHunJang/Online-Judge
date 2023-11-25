import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            Map<Integer,Integer> map = new HashMap<>();
            
            for(int i = 0; i < 3; i++) {
            	int n = sc.nextInt();
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
           	
            int answer = 0;
            for(int k : map.keySet()) {
                if(map.get(k) % 2 != 0) answer = k;
            }
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}