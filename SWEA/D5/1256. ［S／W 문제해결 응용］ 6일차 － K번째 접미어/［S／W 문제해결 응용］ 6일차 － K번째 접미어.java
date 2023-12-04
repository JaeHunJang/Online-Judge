import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution
{
	public static void main(String args[]) throws Exception
	{		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			String s = sc.next();
			
			List<String> list = new ArrayList<>();
			for(int i = 0; i < s.length(); i++) {
				list.add(s.substring(i, s.length()));
			}
			Collections.sort(list);
			
			System.out.println("#" + test_case + " " + list.get(n-1));
		}
	}
}