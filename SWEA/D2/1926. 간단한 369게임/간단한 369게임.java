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
            String s = test_case + "";
            String dash = "";
            for(String ch : s.split("")) {
                if(ch.matches("[369]"))
                	dash += "-";
            }
            if(dash.equals(""))
            	System.out.print(s + " ");
            else 
                System.out.print(dash + " ");
		}
	}
}