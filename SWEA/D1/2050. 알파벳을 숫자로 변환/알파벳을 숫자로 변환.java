// g = sc.nextByte();                          // char 변수 1개 입력받는 예제

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		for(char ch : s.toCharArray())
		{
            System.out.print(ch - 64 + " ");
		}
	}
}