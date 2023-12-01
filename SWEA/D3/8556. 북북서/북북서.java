import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String s = sc.next();
			
			double dir = 0;
			int count = 0;
			double divide = 0;
			
            while(s.length() > 0) {
            	divide = Math.pow(2, count++);
            	if(s.endsWith("north")) {
        			dir -= 90 / divide;
        			if(dir < 0) dir = 0;
        			s = s.substring(0, s.lastIndexOf("north"));
        		}
        		else if(s.endsWith("west")){
        			dir += 90 / divide;
        			s = s.substring(0, s.lastIndexOf("west"));
        		}
            }
            divide /= 2;
            if((int)dir == dir)
            	System.out.println("#" + test_case + " " + (int)dir);
            else 
            	System.out.println("#" + test_case + " " + (int)(dir*divide) + "/" + (int)divide);
		}
	}
}