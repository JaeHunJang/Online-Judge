import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		String[] tokens = exp.split("\\-");
		int result = Integer.MAX_VALUE;
		for (String e : tokens) {
			int sum = 0;
			for (String n : e.split("\\+")) {
				sum += Integer.parseInt(n);
			}
			if (result == Integer.MAX_VALUE) {
				result = sum;
			} else {
				result -= sum;
			}
		}
		System.out.println(result);
	}
}