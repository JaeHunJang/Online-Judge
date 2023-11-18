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
            int n = sc.nextInt();
            int answer = 0;
            int nowSpeed = 0;
            for(int i = 0; i < n; i++) {
            	int cmd = sc.nextInt();
            	int speed = 0;
            	if(cmd == 1) speed = sc.nextInt();
            	else if(cmd == 2) speed = sc.nextInt() * -1;
            	nowSpeed += speed;
            	if(nowSpeed < 0) {
            		nowSpeed = 0;
            	}
            	
            	
            	answer += nowSpeed;
            }
            System.out.println(answer);
		}
	}
}