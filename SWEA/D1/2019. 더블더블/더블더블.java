import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int answer = 1;
        System.out.print(answer + " ");
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer *= 2;
            System.out.print(answer + " ");
		}
	}
}