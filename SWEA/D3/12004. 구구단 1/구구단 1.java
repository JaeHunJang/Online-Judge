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
			
			String answer = "No";
			
			for(int i = 1; i <= 9; i++) {
				for(int j = 1; j <= 9; j++) {
					if(i * j == n) {
						answer = "Yes";
						break;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}