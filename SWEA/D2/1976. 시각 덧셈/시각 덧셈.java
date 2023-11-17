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
           	int hour = sc.nextInt();
            int min = sc.nextInt();
            hour += sc.nextInt();
            min += sc.nextInt();
            if(min / 60 > 0) 
                hour += min / 60;
            hour = (hour % 12) == 0 ? 12 : (hour % 12);
            System.out.println(hour + " " + (min % 60));
		}
	}
}