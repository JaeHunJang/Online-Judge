import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        Map<Integer, Integer> map = new HashMap();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + sc.nextInt() + " ");
            int maxCount = 0;
        	int answer = 0;
            for(int i = 1; i <= 1000; i++){
                int n = sc.nextInt();
                map.put(n, map.getOrDefault(n, 0)+1);
                
                int count = map.get(n);
                if(count > maxCount) {
                    maxCount = count;
                    answer = n;
                } else if (count == maxCount) {
                    if(n > answer) {
                        answer = n;
                    }
                }
            }
            map.clear();
            System.out.println(answer);
		}
	}
}