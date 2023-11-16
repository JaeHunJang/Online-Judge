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
            System.out.print("#" + test_case + " ");
            int answer = 0;
            String s = sc.next();
            StringBuilder sb = new StringBuilder(s.substring(0, s.length()/2));
            sb.reverse();
            if (s.endsWith(sb.toString()))
                answer = 1;
            System.out.println(answer);
		}
	}
}