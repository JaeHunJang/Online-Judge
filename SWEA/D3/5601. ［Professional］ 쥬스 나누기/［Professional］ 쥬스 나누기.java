import java.util.Scanner;
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
            String answer = "";
            for(int i = 0; i < n; i++) 
                answer += "1/" + n + " ";
			System.out.println("#" + test_case + " " + answer);
		}
	}
}