import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(new BigInteger("2").pow(n).subtract(new BigInteger("1")).toString());
		if (n <= 20) {
			hanoi(n, 1, 2, 3);
			System.out.println(sb.toString());
		}
	}
	
	private static void hanoi(int n, int from, int temp, int to) {
		if (n == 0) return;
		hanoi(n-1, from, to, temp);
		sb.append(from + " " + to + "\n");
		hanoi(n-1, temp, from, to);
	}
}
