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
			String[] now = sc.next().split(":");
			String[] next = sc.next().split(":");
			int[] answer = { 
					Integer.parseInt(next[0]) -  Integer.parseInt(now[0]),
					Integer.parseInt(next[1]) -  Integer.parseInt(now[1]),
					Integer.parseInt(next[2]) -  Integer.parseInt(now[2])
			};
			
			if (answer[2] < 0) {
				answer[2] += 60;
				answer[1]--;
			}
			if (answer[1] < 0) {
				answer[1] += 60;
				answer[0]--;
			}
			if (answer[0] < 0) {
				answer[0] += 24;
			}
			
			System.out.printf("#%d %02d:%02d:%02d\n", test_case, answer[0], answer[1], answer[2]);
		}
	}
}