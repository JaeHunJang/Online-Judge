import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
        
        int answer = 0;

		for(String n : s.split(""))
		{
			answer += Integer.parseInt(n);
		}
        System.out.println(answer);
	}
}