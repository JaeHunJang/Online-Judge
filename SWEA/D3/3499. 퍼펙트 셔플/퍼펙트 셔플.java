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
			int n = sc.nextInt();
			
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++)
				list.add(sc.next());
			
			List<String> list2 = list.subList(n / 2 + n % 2, n);
			
			String answer = "";
			for(int i = 0; i < n / 2; i++) {
				answer += list.get(i) + " ";
				answer += list2.get(i) + " ";
			}
            if(n % 2 != 0) answer += list.get(n / 2);
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}