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
            int P = sc.nextInt(); //리터당
            int Q = sc.nextInt(); //일정미만 요금
            int R = sc.nextInt(); //일정치
            int S = sc.nextInt(); //리터당
            int W = sc.nextInt(); //사용량
            int answer = 0;
            if(R > W) {
            	answer = Math.min(P * W, Q);
            } else {
            	answer = Math.min(P * W, (W-R) * S + Q);
            }
            System.out.println(answer);
		}
	}
}