import java.util.*;
import java.math.BigInteger;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.println("#" + test_case + " " + new BigInteger(sc.next()).add(new BigInteger(sc.next())).toString());
		}
	}
}