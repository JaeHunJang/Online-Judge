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
            for(int i = 0; i < n; i++)
                list.add(sc.nextInt());
            
            int answer = list.stream().mapToInt(Integer::intValue).max().getAsInt() + list.stream().mapToInt(Integer::intValue).sum() + n;
			System.out.println("#" + test_case + " " + answer);
		}
	}
}