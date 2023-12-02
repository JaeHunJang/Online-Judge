import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
			int answer = 0;
            for(String n : sc.next().split("\\+")) {
            	answer += Integer.parseInt(n);
            }
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}