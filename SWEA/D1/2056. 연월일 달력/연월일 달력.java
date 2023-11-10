import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int[] days = {0, 31,28,31,30,31,30,31,31,30,31,30,31 };
        
        int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");

            String date = sc.next();
            String year = date.substring(0, 4);
			String month = date.substring(4, 6);
			String day = date.substring(6, 8);
            if(Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= days[Integer.parseInt(month)])
        		System.out.println(year + "/" + month + "/" + day);
            else
                System.out.println("-1");
		}
	}
}