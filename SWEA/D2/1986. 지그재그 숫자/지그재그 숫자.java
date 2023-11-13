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
            System.out.print("#"+test_case+" ");
            int answer = 0;
            int max = sc.nextInt();
			for(int n = 1; n <= max; n++) {
			if (n % 2 == 1)
                answer += n;
            else
                answer -= n;
            }
            System.out.println(answer);
		}
	}
}