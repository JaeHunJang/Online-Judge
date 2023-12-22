import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		
		for(int i = 0; i < n; i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}