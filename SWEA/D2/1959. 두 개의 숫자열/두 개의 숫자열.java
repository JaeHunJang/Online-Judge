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
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			
			for(int i = 0; i < n; i++)
				list1.add(sc.nextInt());
			for(int i = 0; i < m; i++)
				list2.add(sc.nextInt());
			
			int answer;
			if(list1.size() > list2.size())
				answer = calc(list1, list2);
			else
				answer = calc(list2, list1);
			
			System.out.println("#" + test_case + " " + answer);

		}
	}
    
    public static int calc(List<Integer> bigger, List<Integer> smaller) {
		int n = smaller.size();
		
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		int max = 0;
		for(int i = 0; i < bigger.size() - n + 1; i++) {
			sum = 0;
			for(int j = 0; j < n; j++) {
				sum += smaller.get(j) * bigger.get(j + i);
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}