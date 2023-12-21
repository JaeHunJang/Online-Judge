import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(sc.next());
		}
		
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length())
					return 1;
				else if (o1.length() < o2.length())
					return -1;
				else 
					return o1.compareTo(o2);
			}
		});
		
		list.stream().distinct().forEach(System.out::println);
	}
} 