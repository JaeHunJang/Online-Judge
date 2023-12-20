import java.util.Scanner;
//1259
class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String n = sc.next();
			if (n.equals("0")) break;
			
			String answer = "no";
			if (n.endsWith(new StringBuilder(n.substring(0, n.length() / 2)).reverse().toString()))
				answer = "yes";
			
			System.out.println(answer);
		}
	}
}