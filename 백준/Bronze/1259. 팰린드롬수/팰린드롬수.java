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
			char[] arr = n.toCharArray();
			
			String answer = "yes";
            for(int i = 0; i < arr.length / 2; i++) {
                if(arr[i] != arr[arr.length - 1 - i]) answer = "no";
            }
			
			System.out.println(answer);
		}
	}
}