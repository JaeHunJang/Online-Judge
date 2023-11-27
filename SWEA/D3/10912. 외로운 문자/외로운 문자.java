import java.util.*;
import java.util.stream.Collectors;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.next();
			
			String answer = "";
			
			for(String ch : Arrays.stream(s.split(""))
				.distinct()
				.sorted()
				.filter(item -> (s.length() - s.replace(item, "").length()) % 2 != 0)
				.collect(Collectors.toList())) {
				answer += ch;
			}
			
			if(answer.equals("")) answer = "Good";

			System.out.println("#" + test_case + " " + answer);
		}
	}
}