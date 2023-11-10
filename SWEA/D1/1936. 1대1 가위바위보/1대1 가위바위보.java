import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
        
        if(a + b == 4) {
            if(a > b) System.out.print("B");
            else System.out.print("A");
        } else {
            if(a > b) System.out.print("A");
            else System.out.print("B");
        }
            

	}
}