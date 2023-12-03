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
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			
			Collections.sort(list);
			int answer = 0;
			if(list.size() % 2 == 0) {
				answer = list.get(0) * list.get(list.size()-1);
			} else {
				answer = (int) Math.pow(list.get(list.size()/2), 2);
			}
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}