import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
		for (int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			
			int answer = 0;
			for(int i = 2; i < n - 2; i++) {
				answer += check(list, i);
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
    
    static int check(List<Integer> list, int idx) {
		int[] d = { -2, -1, 1, 2 };
		int count = Integer.MAX_VALUE;
		boolean flag = true;
		for(int i = 0; i < d.length; i++) {
			if (list.get(idx) > list.get(idx - d[i])) {
				count = Math.min(list.get(idx) - list.get(idx - d[i]), count);
			} else flag = false;
		}
		if (flag) return count;
		else return 0;
	}
}