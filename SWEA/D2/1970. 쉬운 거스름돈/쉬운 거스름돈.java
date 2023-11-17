import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.println("#" + test_case + " ");
            int[] answers = new int[coins.length];
            int money = sc.nextInt();
			for(int i = 0; i < coins.length; i++) {
                if(money / coins[i] > 0) {
                    answers[i] = money / coins[i];
                    money = money % coins[i];
                }
            }
            for(int answer : answers) 
            	System.out.print(answer + " ");
            System.out.println();
		}
	}
}