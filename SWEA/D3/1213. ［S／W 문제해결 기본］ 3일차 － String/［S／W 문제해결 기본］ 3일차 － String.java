import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            sc.nextInt();
			String word = sc.next();
            String s = sc.next();

            int answer = 0;
            for(int i = 0; i < s.length() - word.length() + 1; i++) {
                if (s.substring(i, i + word.length()).equals(word)) answer++;
            }
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}