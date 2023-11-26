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
			String[] balls = { "(|", "|)", "()" };
			String s = sc.next();
			
			int answer = 0;
			for(int i = 0; i < s.length()-1; i++) {
				for(String ball : balls) {
					if(ball.equals(s.substring(i, i+2))) {
						answer++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}