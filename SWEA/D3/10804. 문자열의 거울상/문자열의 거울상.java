import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        
        String[] arr = {"b", "d", "p", "q"};
        String[] mirror = {"d", "b", "q", "p"};
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String s = sc.next();
            s = new StringBuilder(s).reverse().toString();
            for(int i = 0; i < arr.length; i++) {
                s = s.replaceAll(arr[i], i+"");
            }
            for(int i = 0; i < mirror.length; i++) {
                s = s.replaceAll(i+"", mirror[i]);
            }
            
            
			System.out.println("#" + test_case + " " + s);
		}
	}
}