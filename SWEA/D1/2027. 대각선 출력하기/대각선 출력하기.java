import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 5; test_case++)
		{
            for(int i = 1; i <= 5; i++) {
                if(test_case == i)
                    System.out.print("#");
                else
                	System.out.print("+");
            }
            System.out.println();
		}
	}
}