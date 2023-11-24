import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			System.out.println("#" + sc.nextInt() + " " + (int)Math.pow(sc.nextInt(), sc.nextInt()));
		}
	}
}